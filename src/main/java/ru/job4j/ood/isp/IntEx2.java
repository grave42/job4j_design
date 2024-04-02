package ru.job4j.ood.isp;

/**
 * Этот интерфейс представляет функциональность управления транспортным средством.
 * Но если у нас есть класс,
 * который представляет лодку,
 * у которой нет двигателя и методы startEngine() и stopEngine() не имеют смысла
 */

interface IntEx2 {
    void startEngine();
    void stopEngine();
    void accelerate();
    void brake();
    void turnLeft();
    void turnRight();
}
