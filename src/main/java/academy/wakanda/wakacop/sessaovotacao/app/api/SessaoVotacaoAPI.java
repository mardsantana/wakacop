package academy.wakanda.wakacop.sessaovotacao.app.api;

import academy.wakanda.wakacop.api.VotoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacaoAPI {
    @PostMapping("/abertura")
    @ResponseStatus(code = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);

    @PostMapping("/{idSessao}/voto")
    @ResponseStatus(code = HttpStatus.CREATED)
    VotoResponse recebeVoto(@PathVariable UUID idSessao, @RequestBody VotoRequest novoVoto);

    @GetMapping("/{idSessao}/resultado")
    @ResponseStatus(HttpStatus.OK)
    ResultadoSessaoResponse obtemResultado(@PathVariable UUID idSessao);
}
