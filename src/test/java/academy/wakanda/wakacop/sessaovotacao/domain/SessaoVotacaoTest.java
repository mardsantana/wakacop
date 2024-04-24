package academy.wakanda.wakacop.sessaovotacao.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessaoVotacaoTest {

    @Test
    void deveFecharSessaoQuandoChamarMetodoFechaSessao(){
        SessaoVotacao sessao = buildeSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.fechaSessao(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA,sessao.getStatus());
    }

    @Test
    void deveFecharSessaoQuandoStatusAbertaEMomentoEncerramentoEstiveremNoPassado(){
        SessaoVotacao sessao = buildeSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA,sessao.getStatus());
    }

    @Test
    void deveFicarAbertaSessaoQuandoStatusAbertaEMomentoEncerramentoEstiveremNoFuturo(){
        SessaoVotacao sessao = buildeSessaoEncerramentoFuturo();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.ABERTA,sessao.getStatus());
    }

    private SessaoVotacao buildeSessaoEncerramentoFuturo() {
        return SessaoVotacao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .status(StatusSessaoVotacao.ABERTA)
                .momentoAbertura(LocalDateTime.of(2023,1,1,1,1))
                .momentoEncerramento(LocalDateTime.MAX)
                .votos(getVotos())
                .build();
    }

    private SessaoVotacao buildeSessao() {
        return SessaoVotacao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .status(StatusSessaoVotacao.ABERTA)
                .momentoAbertura(LocalDateTime.of(2023,1,1,1,1))
                .momentoEncerramento(LocalDateTime.of(2023,1,1,1,2))
                .votos(getVotos())
                .build();
    }

    private Map<String, VotoPauta> getVotos() {
        return Map.of("07785679584",VotoPauta.builder().cpfAssociado("07785679584").opcaoVoto(OpcaoVoto.SIM).build(),
                "07785679585",VotoPauta.builder().cpfAssociado("07785679585").opcaoVoto(OpcaoVoto.NAO).build());
    }

}