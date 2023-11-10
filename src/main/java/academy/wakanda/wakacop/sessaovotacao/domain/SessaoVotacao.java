package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


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
    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest) {
        this.idPauta = sessaoAberturaRequest.getIdPauta();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.dataAbertura = LocalDateTime.now();
    }
}
