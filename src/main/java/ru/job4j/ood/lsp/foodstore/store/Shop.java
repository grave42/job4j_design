package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

public class Shop extends AbstractStore {

    private final double minExp = 25.0;

    private final double maxExp = 75.0;

    private final double fullExp = 100.0;
    @Override
    public void addProduct(Food product) {
        super.addProduct(product);
        System.out.println("Product added to the shop: " + product.getName());
    }

    @Override
    public boolean checkStore(Food product) {
        boolean result = false;
        double actualExp = product.calculateExpirationPercentage();
        if (actualExp >= minExp && actualExp < maxExp) {
            result = true;
        } else if (actualExp >= maxExp && actualExp < fullExp) {
            product.makeDiscount();
            result = true;
        }
        return result;
    }
}
