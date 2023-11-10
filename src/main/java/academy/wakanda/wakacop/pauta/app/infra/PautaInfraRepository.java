package academy.wakanda.wakacop.pauta.app.infra;

import academy.wakanda.wakacop.pauta.app.repository.PautaRepository;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {

    private final PautaSpringDataJPARepository pautaSpringDataJPARepository;

    @Override
    public Pauta save(Pauta pauta) {
        log.info("[start] PautaInfraRepository - save");
        pautaSpringDataJPARepository.save(pauta);
        log.info("[finish] PautaInfraRepository - save");
        return pauta;
    }
}
