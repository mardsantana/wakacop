package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ResultadoSessaoResponse {
    private UUID id;
    private UUID idPauta;
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public ResultadoSessaoResponse(SessaoVotacao sessao) {
        this.id = sessao.getId();
        this.idPauta = sessao.getIdPauta();
        this.status = sessao.getStatus();
        this.momentoAbertura = sessao.getMomentoAbertura();
        this.momentoEncerramento = sessao.getMomentoEncerramento();
        this.totalVotos = sessao.getTotalVotos();
        this.totalSim = sessao.getTotalSim();
        this.totalNao = sessao.getTotalNao();
    }
}
