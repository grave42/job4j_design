package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.food.Milk;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {

    Food badMilk = new Milk("Milk", LocalDate.of(2024, 3, 30), LocalDate.of(2024, 3, 1), 90.0);

    Food goodMilk = new Milk("Milk", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 3, 1), 90.0);

    Trash store = new Trash();

    @Test
    void checkStoreIsFalse() {
        assertFalse(store.checkStore(goodMilk));
    }

    @Test
    void checkStoreIsTrue() {
        System.out.println(badMilk.calculateExpirationPercentage());
        assertTrue(store.checkStore(badMilk));
    }

    @Test
    void successAddToStore() {
        store.addProduct(badMilk);
        assertEquals(1, store.getProducts().size());
    }
}