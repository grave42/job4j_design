package ru.job4j.ood.isp;

/**
 * Этот интерфейс представляет функциональность для животных,
 * которые могут есть, спать, летать и плавать.
 * Если у нас есть класс, который представляет змею,
 * у которой нет возможности летать, метод fly() тогда лишний
 */

public interface IntEx3 {
    void eat();

    void sleep();

    void fly();

    void swim();
}
