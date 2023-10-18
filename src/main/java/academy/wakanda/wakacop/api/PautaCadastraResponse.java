package academy.wakanda.wakacop.api;

import academy.wakanda.wakacop.domain.Pauta;
import lombok.*;

import java.util.UUID;

//@Getter
//@ToString
@Value
@Builder
public class PautaCadastraResponse {
    private UUID id;
}
