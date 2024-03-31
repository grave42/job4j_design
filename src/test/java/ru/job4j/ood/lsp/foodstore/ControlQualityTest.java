package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.food.Milk;
import ru.job4j.ood.lsp.foodstore.store.Shop;
import ru.job4j.ood.lsp.foodstore.store.Store;
import ru.job4j.ood.lsp.foodstore.store.Trash;
import ru.job4j.ood.lsp.foodstore.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {

    List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());

    @Test
    public void addMilkToShop() {
        Food milk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 1), 90.0);
        ControlQuality controlProduct = new ControlQuality(milk, stores);
        controlProduct.checkFoodAndAddToStore();
        boolean containsMilk = stores.get(1).getProducts().stream().anyMatch(product -> product.getName().equalsIgnoreCase("Milk"));
        assertTrue(containsMilk, "List should contain 'Milk'");
    }

    @Test
    public void addMilkToShopAndDiscountPrice() {
        Food milk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 1), 90.0);
        ControlQuality controlProduct = new ControlQuality(milk, stores);
        controlProduct.checkFoodAndAddToStore();
        double exeprtedPrice = 72.0;
        double discPrice = milk.getPrice();
        assertEquals(exeprtedPrice, discPrice);
    }

    @Test
    public void addMilkToWarehouse() {
        Food milk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 30), 90.0);
        ControlQuality controlProduct = new ControlQuality(milk, stores);
        controlProduct.checkFoodAndAddToStore();
        boolean containsMilk = stores.get(0).getProducts().stream().anyMatch(product -> product.getName().equalsIgnoreCase("Milk"));
        assertTrue(containsMilk, "List should contain 'Milk'");
    }

    @Test
    public void addMilkToTrash() {
        Food milk = new Milk("Milk", LocalDate.of(2024, 3, 30), LocalDate.of(2024, 3, 1), 90.0);
        ControlQuality controlProduct = new ControlQuality(milk, stores);
        controlProduct.checkFoodAndAddToStore();
        boolean containsMilk = stores.get(2).getProducts().stream().anyMatch(product -> product.getName().equalsIgnoreCase("Milk"));
        assertTrue(containsMilk, "List should contain 'Milk'");
    }

    @Test
    public void addTwoProductsAndOneOfThemIsBread() {
        Food milk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 30), 90.0);
        Food bread = new Milk("Bread", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 30), 70.0);
        ControlQuality controlProduct = new ControlQuality(milk, stores);
        ControlQuality controlProduct2 = new ControlQuality(bread, stores);
        controlProduct.checkFoodAndAddToStore();
        controlProduct2.checkFoodAndAddToStore();
        boolean containsMilk = stores.get(0).getProducts().stream().anyMatch(product -> product.getName().equalsIgnoreCase("Bread"));
        assertTrue(containsMilk, "List should contain 'Bread'");
    }

}