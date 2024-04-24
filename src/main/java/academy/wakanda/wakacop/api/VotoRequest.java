package academy.wakanda.wakacop.api;

import academy.wakanda.wakacop.sessaovotacao.domain.OpcaoVoto;
import lombok.*;
@Getter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcaoVoto;
}
