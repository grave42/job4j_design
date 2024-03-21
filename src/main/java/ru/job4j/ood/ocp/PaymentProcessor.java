package ru.job4j.ood.ocp;

public class PaymentProcessor {
    public void processPayment(double amount, String paymentMethod) {
        if (paymentMethod.equals("credit_card")) {
            processCreditCard(amount);
        } else if (paymentMethod.equals("paypal")) {
            processPaypal(amount);
        } else if (paymentMethod.equals("bitcoin")) {
            processBitcoin(amount);
        }
    }

    public void processCreditCard(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    public void processPaypal(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    public void processBitcoin(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }

    // Нарушение OCP: изменение логики существующей функции processCreditCard
    // например мы хотим добавить комиссию к сумме платежа, тогда нам нужно менять логику метода processCreditCard
//    public void processCreditCard(double amount) {
//        double commission = amount * 0.02;
//        double totalAmount = amount + commission;
//        System.out.println("Processing credit card payment of $" + totalAmount + " with 2% commission");
//    }
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(100, "credit_card");
    }
}
