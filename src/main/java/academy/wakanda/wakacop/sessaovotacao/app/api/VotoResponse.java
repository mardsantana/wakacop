package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.sessaovotacao.domain.VotoPauta;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class VotoResponse {

    private UUID id;
    private UUID idSessao;
    private String cpfAssociado;
    private LocalDateTime momentoVoto;
    public VotoResponse(VotoPauta voto) {
        this.id = voto.getId();
        this.idSessao = voto.getIdSessao();
        this.cpfAssociado = voto.getCpfAssociado();
        this.momentoVoto = voto.getMomentoVoto();
    }
}
