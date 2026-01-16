# Notification Service

Microserviço responsável por notificar os usuários sobre eventos ocorridos no ecossistema PayFlow (ex: recebimento de transferência).

## 🚀 Visão Geral

Este serviço atua como um consumidor puro (Worker). Ele não expõe APIs de negócio, mas reage a eventos de sucesso financeiro para engajar o usuário, simulando o envio de e-mails.

**Principais Responsabilidades:**
- Escutar exchange de sucessos.
- Integrar com provedores de E-mail (Mockado/JavaMail).
- Garantir que a notificação seja tentada mesmo em caso de falhas temporárias.

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Cloud Stream** (RabbitMQ)
- **Spring Mail** (JavaMailSender)

## 📨 Integração (Events)

- **Consome:** `transfer.success` (Exchange: `payflow-exchange`)
    - **Payload esperado:**
      ```json
      {
          "transferId": "a847fd5e-052e-42bb-82cb-842b09af6233",
          "payer": {
              "payerId": "8d53eab3-854f-4691-a3bf-90b7c6e7bd29",
              "name": "John Doe",
              "email": "johndoe@example.com"
          },
          "payee": {
              "payeeId": "692770fb-8550-427c-a035-7ad89aa460c5",
              "name": "Kleber Sanches",
              "email": "klebersanches@example.com"
          },
          "amount": 100.00,
          "status": "COMPLETED",
          "createdAt": "2026-01-16T11:13:57",
          "payflow": {
            "traceId": "a847fd5e-052e-42bb-82cb-842b09af6233"
          }
      }
      ```

## 🔮 Melhorias Futuras

- [ ] Adicionar integração com **AWS SES** ou **SendGrid** para envio real.
- [ ] Criar integração com **SMS (Twilio)** ou **WhatsApp Business API**.
- [ ] Implementar lógica de "Preferências de Notificação" (o usuário escolhe se quer Email ou SMS).