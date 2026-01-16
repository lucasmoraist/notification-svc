package com.lucasmoraist.notification_svc.application.utils;

import com.lucasmoraist.notification_svc.domain.enums.PaymentStatus;
import com.lucasmoraist.notification_svc.domain.message.PaymentMessage;

public final class BuildMessageUtils {

    private BuildMessageUtils() {
    }

    public static String messageToPayee(PaymentMessage paymentMessage) {
        return String.format("Transferência de R$ $%.2f recebida", paymentMessage.amount());
    }

    public static String messageToPayer(PaymentMessage paymentMessage) {
        return PaymentStatus.COMPLETED.equals(paymentMessage.status())
                ? String.format("Pagamento confirmado! Sua transferência de R$ $%.2f para %s foi realizada com sucesso.", paymentMessage.amount(), paymentMessage.payee().name())
                : "Não foi possível concluir seu pagamento";
    }

}
