package com.lucasmoraist.notification_svc.infrastructure.service.email;

import com.lucasmoraist.notification_svc.domain.model.Notification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(Notification notification) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            helper.setTo(notification.recipient());
            helper.setSubject(notification.subject());
            helper.setText(notification.message());
            log.debug("Sending confirmation email to: {}", notification.recipient());

            javaMailSender.send(message);
            log.info("Confirmation email sent successfully to: {}", notification.recipient());
        } catch (MessagingException e) {
            log.error("Error creating email message", e);
        }
    }

}
