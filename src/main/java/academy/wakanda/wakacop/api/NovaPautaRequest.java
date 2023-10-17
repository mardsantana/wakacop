package academy.wakanda.wakacop.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class NovaPautaRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private UUID idAssociadoAutor;
}
