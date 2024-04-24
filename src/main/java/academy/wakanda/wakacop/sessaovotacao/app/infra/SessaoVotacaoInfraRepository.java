package academy.wakanda.wakacop.sessaovotacao.app.infra;

import academy.wakanda.wakacop.sessaovotacao.app.repository.SessaoVotacaoRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;
    @Override
    public SessaoVotacao save(SessaoVotacao sessaoVotacao) {
        log.info("[start] SessaoVotacaoInfraRepository - save");
        sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
        log.info("[finish] SessaoVotacaoInfraRepository - save");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaPorID(UUID idSessao) {
        log.info("[start] SessaoVotacaoInfraRepository - buscaPorID");
        SessaoVotacao sessao = sessaoVotacaoSpringDataJPARepository.findById(idSessao)
                        .orElseThrow(() -> new RuntimeException("Sessão não Encontrada!!"));
        log.info("[finish] SessaoVotacaoInfraRepository - buscaPorID");
        return sessao;
    }

    @Override
    public List<SessaoVotacao> buscaAbertas() {
        log.debug("[start] SessaoVotacaoInfraRepository - buscaAbertas");
        List<SessaoVotacao> sessoes = sessaoVotacaoSpringDataJPARepository.findByStatus(StatusSessaoVotacao.ABERTA);
        log.debug("[finish] SessaoVotacaoInfraRepository - buscaAbertas");
        return sessoes;
    }
}
