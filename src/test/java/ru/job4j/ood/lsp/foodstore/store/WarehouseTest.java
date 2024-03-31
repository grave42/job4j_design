package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.food.Milk;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    Warehouse store = new Warehouse();

    Food goodMilk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 1), 90.0);

    Food badMilk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 30), 90.0);


    @Test
    void checkStoreIsTrue() {
        assertFalse(store.checkStore(goodMilk));
    }

    @Test
    void checkStoreIsFalse() {
        assertTrue(store.checkStore(badMilk));
    }

    @Test
    void successAddToStore() {
        store.addProduct(goodMilk);
        assertEquals(1, store.getProducts().size());
    }
}