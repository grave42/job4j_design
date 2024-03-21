package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double getPrice() {
        return 1D;
    }
}


class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Нарушение OCP: новая функциональность требует добавления поля
    // Допустим, теперь требуется учитывать скидку на товары
    // При этом добавление нового поля для скидки приведет к модификации класса ShoppingCart
    // и нарушению принципа OCP
    // private double discount;
}