package academy.wakanda.wakacop.sessaovotacao.app.service;

import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaResponse;

public interface SessaoAberturaService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
