package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    @Test
    void getExpectedAnswerIsFizz() {
        String result = Fool.getExpectedAnswer(6);
        assertEquals("Fizz", result);
    }

    @Test
    void getExpectedAnswerIsNumber() {
        String result = Fool.getExpectedAnswer(7);
        assertEquals("7", result);
    }
}