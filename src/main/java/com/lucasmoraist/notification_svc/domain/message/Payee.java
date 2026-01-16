package com.lucasmoraist.notification_svc.domain.message;

import java.util.UUID;

public record Payee(
        UUID payeeId,
        String name,
        String email
) {

}
