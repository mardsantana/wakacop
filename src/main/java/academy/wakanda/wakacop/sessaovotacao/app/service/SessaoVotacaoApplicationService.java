package academy.wakanda.wakacop.sessaovotacao.app.service;

import academy.wakanda.wakacop.api.VotoRequest;
import academy.wakanda.wakacop.associado.app.service.AssociadoService;
import academy.wakanda.wakacop.pauta.app.domain.Pauta;
import academy.wakanda.wakacop.pauta.app.service.PautaService;
import academy.wakanda.wakacop.sessaovotacao.app.api.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.app.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.app.api.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.app.repository.SessaoVotacaoRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domain.VotoPauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoApplicationService implements SessaoAberturaService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;
    private final PublicadorResultadoSessao publicadorResultadoSessao;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.save(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info("[start] SessaoVotacaoApplicationService - recebeVoto");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorID(idSessao);
        VotoPauta voto = sessao.recebeVoto(novoVoto, associadoService, publicadorResultadoSessao);
        sessaoVotacaoRepository.save(sessao);
        log.info("[finish] SessaoVotacaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.info("[start] SessaoVotacaoApplicationService - obtemResultado");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorID(idSessao);
        ResultadoSessaoResponse resultado = sessao.obtemResultado(publicadorResultadoSessao);
        sessaoVotacaoRepository.save(sessao);
        log.info("[finish] SessaoVotacaoApplicationService - obtemResultado");
        return resultado;
    }
}
