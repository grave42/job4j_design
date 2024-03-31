package ru.job4j.ood.lsp.foodstore;

import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.store.Store;

import java.util.List;

public class ControlQuality {

    private Food product;

    private List<Store> stores;

    public ControlQuality(Food product, List<Store> stores) {
        this.product = product;
        this.stores = stores;
    }

    public void checkFoodAndAddToStore() {
        for (Store store : stores) {
            boolean result = store.checkStore(product);
            if (result) {
                store.addProduct(product);
            }
        }
    }
}
