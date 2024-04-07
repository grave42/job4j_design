package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractStore implements Store {
    protected List<Food> products;

    public AbstractStore() {
        products = new ArrayList<>();
    }

    public void addProduct(Food product) {
        products.add(product);
    }

    public abstract boolean checkStore(Food product);

    public List<Food> getProducts() {
        return products;
    }

    public void restore(Food product) {
        products.add(product);
    }
}