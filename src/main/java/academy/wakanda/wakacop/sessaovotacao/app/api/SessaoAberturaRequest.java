package academy.wakanda.wakacop.sessaovotacao.app.api;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Data
public class SessaoAberturaRequest {
    @NotNull
    @Column(name = "id_pauta")
    private UUID idPauta;
    @Column(name = "tempo_duracao")
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao(){
        return Optional.ofNullable(this.tempoDuracao);
    }
}
