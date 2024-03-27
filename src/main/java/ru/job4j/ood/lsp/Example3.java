package ru.job4j.ood.lsp;


/**
 * Причина нарушения: Метод setSpeed в классе Car усиливает предусловие метода setSpeed базового класса Vehicle, который принимает любое неотрицательное значение.
 * Таким образом, при использовании Car нарушается ожидание вызывающего кода о возможности установки любой неотрицательной скорости.
 */

class Vehicle {
    protected int speed;

    public void setSpeed(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must be non-negative");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

class Car extends Vehicle {
    @Override
    public void setSpeed(int speed) {
        if (speed < 0 || speed > 150) {
            speed = Math.max(0, Math.min(150, speed)); // Ограничиваем скорость от 0 до 150
        }
        this.speed = speed;
    }
}

public class Example3 {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.setSpeed(-50);
    }
}
