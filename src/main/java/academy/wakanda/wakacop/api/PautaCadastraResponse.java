package academy.wakanda.wakacop.api;

import academy.wakanda.wakacop.domain.Pauta;
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
