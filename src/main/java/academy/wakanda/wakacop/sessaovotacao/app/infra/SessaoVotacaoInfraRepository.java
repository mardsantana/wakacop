package academy.wakanda.wakacop.sessaovotacao.app.infra;

import academy.wakanda.wakacop.sessaovotacao.app.repository.SessaoVotacaoRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
