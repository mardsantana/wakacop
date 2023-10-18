package academy.wakanda.wakacop.infra;

import academy.wakanda.wakacop.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {
}
