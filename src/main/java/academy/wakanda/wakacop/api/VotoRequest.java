package academy.wakanda.wakacop.api;

import academy.wakanda.wakacop.sessaovotacao.domain.OpcaoVoto;
import lombok.Data;

@Data
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcaoVoto;
}
