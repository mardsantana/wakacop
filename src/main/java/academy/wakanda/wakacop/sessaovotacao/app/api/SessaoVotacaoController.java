package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.sessaovotacao.app.service.SessaoAberturaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoController implements SessaoVotacaoAPI {
    private final SessaoAberturaService sessaoAberturaService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoVotacaoController - abreSessao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoAberturaService.abreSessao(sessaoAberturaRequest);
        log.info("[finish] SessaoVotacaoController - abreSessao");
        return sessaoAberturaResponse;
    }
}
