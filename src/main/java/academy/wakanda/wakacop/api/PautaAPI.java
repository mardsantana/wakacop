package academy.wakanda.wakacop.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PautaCadastraResponse criaPauta(@RequestBody NovaPautaRequest novaPauta);


}
