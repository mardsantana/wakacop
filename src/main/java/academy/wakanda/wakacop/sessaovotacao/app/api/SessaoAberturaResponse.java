package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.Data;

import java.util.UUID;

@Data
public class SessaoAberturaResponse {
    private UUID idSessao;
    public SessaoAberturaResponse(SessaoVotacao sessaoVotacao) {
        this.idSessao = sessaoVotacao.getId();
    }
}
