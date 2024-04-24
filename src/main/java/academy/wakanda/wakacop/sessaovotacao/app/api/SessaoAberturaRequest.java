package academy.wakanda.wakacop.sessaovotacao.app.api;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao(){
        return Optional.ofNullable(this.tempoDuracao);
    }
}
