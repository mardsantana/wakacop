package academy.wakanda.wakacop.sessaovotacao.app.service;

import academy.wakanda.wakacop.sessaovotacao.app.repository.SessaoVotacaoRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoFechadorService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PublicadorResultadoSessao publicador;

    @Scheduled(cron = "0 * * * * *")
    public void fechaSessoesEncerradas(){
        log.debug("[start] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
        List<SessaoVotacao> sessoesAbertas = sessaoVotacaoRepository.buscaAbertas();
        log.debug("[sessoesAbertas] {}", sessoesAbertas);
        sessoesAbertas.forEach(sessaoVotacao -> {
            sessaoVotacao.obtemResultado(publicador);
            sessaoVotacaoRepository.save(sessaoVotacao);
        });
        log.debug("[finish] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
    }
}
