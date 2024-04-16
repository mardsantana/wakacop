package academy.wakanda.wakacop.associado.app.service;

import academy.wakanda.wakacop.associado.infra.client.SerproClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private final SerproClientFeign serproClientFeign;

    @Override
    public void validaAssociadoAptoVoto(String cpfAssociado) {
        log.info("[start] AssociadoApplicationService - validaAssociadoAptoVoto");

        log.info("[finish] AssociadoApplicationService - validaAssociadoAptoVoto");
    }
}
