package ru.job4j.ood.isp;

import java.util.List;

/**
 * Этот интерфейс представляет доступ к данным,
 * который может выполнять различные операции с данными.
 * Но если у нас есть класс, который должен выполнять только операцию чтения данных
 * (например, getData() и getAllData()),
 * реализация методов для вставки, обновления и удаления данных становится избыточной
 */

public interface IntEx1 {
    void insertData(Object data);

    void updateData(Object data);

    void deleteData(Object data);

    Object getData(int id);

    List<Object> getAllData();
}
