package com.lucasmoraist.notification_svc.infrastructure.config.usecases;

import com.lucasmoraist.notification_svc.application.gateway.NotificationGateway;
import com.lucasmoraist.notification_svc.application.message.OrchestratorMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageUseCases {

    @Bean
    public OrchestratorMessage orchestratorMessage(NotificationGateway notificationGateway) {
        return new OrchestratorMessage(notificationGateway);
    }

}
