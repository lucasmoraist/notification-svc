package com.lucasmoraist.notification_svc.infrastructure.queue.consumer;

import com.lucasmoraist.notification_svc.application.message.OrchestratorMessage;
import com.lucasmoraist.notification_svc.domain.message.PaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class NotificationConsumer {

    private final OrchestratorMessage orchestratorMessage;

    @Bean
    public Consumer<Message<PaymentMessage>> fromWalletCore(){
        return orchestratorMessage::execute;
    }

}
