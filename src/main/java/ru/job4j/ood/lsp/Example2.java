package ru.job4j.ood.lsp;

/**
 * Причина нарушения: Метод fly в классе Ostrich ослабляет постусловия метода fly базового класса Bird, который не предполагает выброс исключения.
 * Это нарушает LSP, так как вызывающий код, полагаясь на поведение fly из Bird, может быть нарушен при использовании Ostrich.
 */

class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly");
    }
}

public class Example2 {
    public static void main(String[] args) {
        Bird bird = new Ostrich();
        bird.fly();
    }
}
