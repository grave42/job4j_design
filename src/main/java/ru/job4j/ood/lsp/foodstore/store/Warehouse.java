package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

public class Warehouse extends AbstractStore {

    private final double minExp = 0.0;

    private final double maxExp = 25.0;

    @Override
    public void addProduct(Food product) {
        super.addProduct(product);
        System.out.println("Product added to the warehouse: " + product.getName());
    }


    @Override
    public boolean checkStore(Food product) {
        boolean result = false;
        double actualExp = product.calculateExpirationPercentage();
        if (actualExp >= minExp && actualExp < maxExp) {
            result = true;
        }
        return result;
    }
}