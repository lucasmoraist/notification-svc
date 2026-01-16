package com.lucasmoraist.notification_svc.domain.model;

public record Notification(
        String recipient,
        String subject,
        String message
) {

}
