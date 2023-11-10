package academy.wakanda.wakacop.sessaovotacao.app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao/abertura")
public interface SessaoVotacaoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
}
