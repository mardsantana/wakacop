package academy.wakanda.wakacop.pauta.app.service;

import academy.wakanda.wakacop.pauta.app.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.app.api.PautaCadastraResponse;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaCadastraResponse pautaCriada(NovaPautaRequest novaPauta);
    Pauta getPautaId(UUID idPauta);
}
