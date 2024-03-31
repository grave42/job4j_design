package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

public class Trash extends AbstractStore {

    private final double fullExp = 100.0;
    @Override
    public void addProduct(Food product) {
        super.addProduct(product);
        System.out.println("Product added to the trash: " + product.getName());
    }

    @Override
    public boolean checkStore(Food product) {
        boolean result = false;
        double actualExp = product.calculateExpirationPercentage();
        if (actualExp >= fullExp) {
            result = true;
        }
        return result;
    }
}