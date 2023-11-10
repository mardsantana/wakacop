package academy.wakanda.wakacop.pauta.app.service;

import academy.wakanda.wakacop.pauta.app.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.app.api.PautaCadastraResponse;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import academy.wakanda.wakacop.pauta.app.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public Pauta getPautaId(UUID idPauta) {
        log.info("[start] PautaApplicationService - getPautaId");
        log.info("[finish] PautaApplicationService - getPautaId");
        return null;
    }
}
