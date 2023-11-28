package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.api.VotoRequest;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "id_pauta")
    private UUID idPauta;
    @Column(name = "tempo_duracao")
    private Integer tempoDuracao;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    @Column(name = "momento_abertura")
    private LocalDateTime momentoAbertura;
    @Column(name = "momento_encerramento")
    private LocalDateTime momentoEncerramento;

    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest){
        validaSessaoAberta();
         validaAssociado(votoRequest.getCpfAssociado());
         VotoPauta voto = new VotoPauta(this, votoRequest);
         votos.put(votoRequest.getCpfAssociado(), voto);
         return voto;
    }

    private void validaSessaoAberta() {
        atualizaStatus();
        if (this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw new RuntimeException("Sessão está Fechada!");
        }
    }

    private void atualizaStatus() {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)){
            if (LocalDateTime.now().isAfter(this.momentoEncerramento)){
                fechaSessao();
            }
        }
    }

    private void fechaSessao() {
        this.status = StatusSessaoVotacao.FECHADA;
    }

    private void validaAssociado(String cpfAssociado) {
             if (this.votos.containsKey(cpfAssociado)){
                 new RuntimeException("Associado já votou nesta Sessão!!");
             }
        }
}
