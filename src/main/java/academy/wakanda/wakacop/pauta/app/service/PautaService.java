package academy.wakanda.wakacop.pauta.app.service;

import academy.wakanda.wakacop.pauta.app.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.app.api.PautaCadastraResponse;

public interface PautaService {
    PautaCadastraResponse pautaCriada(NovaPautaRequest novaPauta);
}
