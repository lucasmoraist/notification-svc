package com.lucasmoraist.notification_svc.domain.message;

import java.util.UUID;

public record Payer(
        UUID payerId,
        String name,
        String email
) {

}
