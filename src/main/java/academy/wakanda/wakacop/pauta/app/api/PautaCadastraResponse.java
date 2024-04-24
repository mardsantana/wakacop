package academy.wakanda.wakacop.pauta.app.api;

import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import lombok.*;

import java.util.UUID;

@Getter
@ToString
public class PautaCadastraResponse {
    private UUID id;

    public PautaCadastraResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
