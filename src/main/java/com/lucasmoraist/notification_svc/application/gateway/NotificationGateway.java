package com.lucasmoraist.notification_svc.application.gateway;

import com.lucasmoraist.notification_svc.domain.enums.PaymentStatus;

public interface NotificationGateway {

    void sendNotification(PaymentStatus paymentStatus, String message, String recipient);

}
