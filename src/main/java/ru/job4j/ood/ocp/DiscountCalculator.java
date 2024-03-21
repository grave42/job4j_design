package ru.job4j.ood.ocp;

public class DiscountCalculator {
    public double calculateDiscount(double totalAmount, String customerType) {
        if (customerType.equals("regular")) {
            return totalAmount * 0.1;
        } else if (customerType.equals("premium")) {
            return totalAmount * 0.2;
        } else if (customerType.equals("vip")) {
            return totalAmount * 0.3;
        }
        return 0;
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        // Нарушение OCP: добавление нового типа клиента "gold"
        // требует изменения метода calculateDiscount
        double discount = calculator.calculateDiscount(100, "gold");
        System.out.println("Discount: $" + discount);
    }
}