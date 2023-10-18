package academy.wakanda.wakacop.infra;

import academy.wakanda.wakacop.domain.Pauta;
import academy.wakanda.wakacop.repository.PautaRepository;
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
