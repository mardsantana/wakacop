package academy.wakanda.wakacop.service;

import academy.wakanda.wakacop.api.NovaPautaRequest;
import academy.wakanda.wakacop.api.PautaCadastraResponse;

public interface PaultaService {
    PautaCadastraResponse pautaCriada(NovaPautaRequest novaPauta);
}
