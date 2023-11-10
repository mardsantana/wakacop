package academy.wakanda.wakacop.sessaovotacao.app.service;

import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.app.repository.SessaoVotacaoRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoAberturaApplicationService implements SessaoAberturaService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoAberturaApplicationService - abreSessao");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.save(new SessaoVotacao(sessaoAberturaRequest));
        log.info("[finish] SessaoAberturaApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
