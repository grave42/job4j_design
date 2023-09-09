package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> testlist = simpleConvert.toList("playstation", "xbox", "nintendo", "pc");
        assertThat(testlist).hasSize(4)
                .contains("pc")
                .last()
                .isEqualTo("pc");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> airplanes = simpleConvert.toSet("Boeing 737", "Airbus A320", "Boeing 737", "TU-154", "Embraer 170");
        assertThat(airplanes).isNotEmpty()
                .hasSize(4)
                .containsAnyOf("TU-154", "Boeing 737")
                .endsWith("TU-154", "Airbus A320");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> clients = simpleConvert.toMap("Ivanov", "Petrov", "Sidorov");
        assertThat(clients).hasSize(3)
                .containsKeys("Ivanov")
                .containsValues(0, 1, 2)
                .doesNotContainKey("Bobrov")
                .containsEntry("Ivanov", 0);
    }
}