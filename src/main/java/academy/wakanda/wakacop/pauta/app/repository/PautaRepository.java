package academy.wakanda.wakacop.pauta.app.repository;

import academy.wakanda.wakacop.pauta.app.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta save(Pauta pauta);
    Pauta buscaPautaPorId(UUID idPauta);
}
