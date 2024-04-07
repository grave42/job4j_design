package ru.job4j.ood.dip;

/**
 * NotificationService привязан к конкретной реализации EmailSender,
 * что делает его нерасширяемым для других типов отправки уведомлений,
 * например, SMS или Push-уведомлений.
 */


public class NotificationService {
    private EmailSender emailSender = new EmailSender();

    public void sendNotification(String message, String recipient) {
        emailSender.sendEmail(message, recipient);
    }
}

class EmailSender {

    public void sendEmail(String message, String recipient) {
    }
}
