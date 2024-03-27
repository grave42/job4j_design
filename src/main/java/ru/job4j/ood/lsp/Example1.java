package ru.job4j.ood.lsp;

/**
 * Причина нарушения: Метод setWidth базового класса Rectangle не выбрасывает исключение, а метод setWidth подкласса Square выбрасывает исключение.
 * Это приводит к нарушению LSP, так как вызывающий код, ожидая только IllegalArgumentException от setWidth,
 * может быть нарушен при использовании Square.
 */


class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
        this.width = height;
    }
}

public class Example1 {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(-5); // Ошибка: выбрасывается исключение IllegalArgumentException
    }
}