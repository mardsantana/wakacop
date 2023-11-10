package academy.wakanda.wakacop.pauta.app.infra;

import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {
}
