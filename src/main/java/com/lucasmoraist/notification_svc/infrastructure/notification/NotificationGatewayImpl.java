package com.lucasmoraist.notification_svc.infrastructure.notification;

import com.lucasmoraist.notification_svc.application.gateway.NotificationGateway;
import com.lucasmoraist.notification_svc.domain.enums.PaymentStatus;
import com.lucasmoraist.notification_svc.domain.model.Notification;
import com.lucasmoraist.notification_svc.infrastructure.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class NotificationGatewayImpl implements NotificationGateway {

    private final EmailService emailService;

    @Override
    public void sendNotification(PaymentStatus paymentStatus, String message, String recipient) {
        log.info("Sending notification to {}: {}", recipient, message);

        String subject = buildSubject(paymentStatus);
        Notification notification = new Notification(recipient, subject, message);

        emailService.sendEmail(notification);
    }

    private String buildSubject(PaymentStatus paymentStatus) {
        return switch (paymentStatus) {
            case COMPLETED -> "Payment Successful";
            case FAILED -> "Payment Failed";
            default -> null;
        };
    }

}
