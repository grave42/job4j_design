package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        Scanner input = new Scanner(System.in);

        while (startAt < 100) {
            String expectedAnswer = getExpectedAnswer(startAt);
            System.out.println(expectedAnswer);
            String answer = input.nextLine();

            if (!expectedAnswer.equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }

            startAt++;
        }
    }

    public static String getExpectedAnswer(int startAt) {
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            return "FizzBuzz";
        } else if (startAt % 3 == 0) {
            return "Fizz";
        } else if (startAt % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(startAt);
        }
    }
}
