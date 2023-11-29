package academy.wakanda.wakacop.sessaovotacao.app.service;

import academy.wakanda.wakacop.api.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.app.api.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.app.api.VotoResponse;

import java.util.UUID;

public interface SessaoAberturaService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
    ResultadoSessaoResponse obtemResultado(UUID idSessao);
}
