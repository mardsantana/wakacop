package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.api.VotoRequest;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoPauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;
    @JoinColumn(name = "cpf_associado")
    private String cpfAssociado;
    @JoinColumn(name = "opcao_voto")
    private OpcaoVoto opcaoVoto;
    @JoinColumn(name = "momento_voto")
    private LocalDateTime momentoVoto;

    public VotoPauta(SessaoVotacao sessaoVotacao, VotoRequest votoRequest) {
        this.sessaoVotacao = sessaoVotacao;
        this.cpfAssociado = votoRequest.getCpfAssociado();
        this.opcaoVoto = votoRequest.getOpcaoVoto();
        this.momentoVoto = LocalDateTime.now();
    }

    public UUID getIdSessao() {
        return this.sessaoVotacao.getId();
    }

    public boolean opcaoIgual(OpcaoVoto opcao){
        return this.opcaoVoto.equals(opcao);
    }

}
