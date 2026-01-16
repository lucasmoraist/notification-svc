package com.lucasmoraist.notification_svc.application.message;

import com.lucasmoraist.notification_svc.application.gateway.NotificationGateway;
import com.lucasmoraist.notification_svc.application.utils.BuildMessageUtils;
import com.lucasmoraist.notification_svc.domain.message.PaymentMessage;
import org.springframework.messaging.Message;

public class OrchestratorMessage {

    private final NotificationGateway notificationGateway;

    public OrchestratorMessage(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    public void execute(Message<PaymentMessage> message) {
        PaymentMessage paymentMessage = message.getPayload();

        String payerMessage = BuildMessageUtils.messageToPayer(paymentMessage);
        String payeeMessage = BuildMessageUtils.messageToPayee(paymentMessage);

        this.notificationGateway.sendNotification(paymentMessage.status(), payerMessage, paymentMessage.payer().email());
        this.notificationGateway.sendNotification(paymentMessage.status(), payeeMessage, paymentMessage.payee().email());
    }

}
