package academy.wakanda.wakacop.sessaovotacao.app.infra;

import academy.wakanda.wakacop.config.AwsConfigProperties;
import academy.wakanda.wakacop.sessaovotacao.app.api.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoInfraSNS implements PublicadorResultadoSessao {

    private final AwsConfigProperties awsSnsProperties;
    private final NotificationMessagingTemplate publicadorResultadosSNS;
    @Override
    public void publica(ResultadoSessaoResponse resultadoSessaoResponse) {
        log.debug("[start] PublicadorResultadoSessaoInfraSNS - publica");
        publicadorResultadosSNS.sendNotification(awsSnsProperties.getResultadoSessaoTopic(), resultadoSessaoResponse,resultadoSessaoResponse.getIdPauta().toString());
        log.debug("[finish] PublicadorResultadoSessaoInfraSNS - publica");
    }
}
