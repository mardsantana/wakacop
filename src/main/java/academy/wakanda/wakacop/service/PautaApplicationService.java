package academy.wakanda.wakacop.service;

import academy.wakanda.wakacop.api.NovaPautaRequest;
import academy.wakanda.wakacop.api.PautaCadastraResponse;
import academy.wakanda.wakacop.domain.Pauta;
import academy.wakanda.wakacop.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PautaApplicationService implements PautaService {

    private final PautaRepository pautaRepository;

    @Override
    public PautaCadastraResponse pautaCriada(NovaPautaRequest novaPauta) {
        log.info("[start] PautaApplicationService - pautaCriada");
        log.info("[novaPauta] {}", novaPauta);
        Pauta pauta = pautaRepository.save(new Pauta(novaPauta));
        log.info("[finish] PautaApplicationService - pautaCriada");
        return new PautaCadastraResponse(pauta);
    }
}
