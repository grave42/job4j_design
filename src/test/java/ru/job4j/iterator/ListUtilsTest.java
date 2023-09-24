package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        Predicate<Integer> filter = s -> s > 2;
        ListUtils.addAfter(input, 0, 2);
        ListUtils.removeIf(input, filter);
        assertThat(input).hasSize(2).contains(1, 2);
    }

    @Test
    void whenReplaceIf() {
        Predicate<Integer> filter = s -> s > 2;
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 1, 4);
        ListUtils.replaceIf(input, filter, 33);
        assertThat(input).hasSize(4).contains(1, 2, 33, 33);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 1, 4);
        ListUtils.removeAll(input, List.of(2, 4));
        assertThat(input).hasSize(2).contains(1, 3);
    }
}