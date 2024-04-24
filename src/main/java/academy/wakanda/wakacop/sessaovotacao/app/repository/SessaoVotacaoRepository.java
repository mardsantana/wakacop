package academy.wakanda.wakacop.sessaovotacao.app.repository;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao save(SessaoVotacao sessaoVotacao);
    SessaoVotacao buscaPorID(UUID idSessao);
    List<SessaoVotacao> buscaAbertas();
}
