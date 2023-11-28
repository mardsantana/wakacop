package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.api.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.app.service.SessaoAberturaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info("[start] SessaoVotacaoController - recebeVoto");
        log.info("[idSessao] {}", idSessao);
        VotoResponse votoResponse = sessaoAberturaService.recebeVoto(idSessao, novoVoto);
        log.info("[finish] SessaoVotacaoController - recebeVoto");
        return votoResponse;
    }
}
