package academy.wakanda.wakacop.api;

import academy.wakanda.wakacop.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/pauta")
public class PautaController implements PautaAPI{

    private final PautaService pautaService;
    @Override
    public PautaCadastraResponse criaPauta(NovaPautaRequest novaPauta) {
        log.info("[start] PautaController - criaPauta");
        PautaCadastraResponse pautaC = pautaService.pautaCriada(novaPauta);
        log.info("[finish] PautaController - criaPauta");
        return pautaC;
    }
}
