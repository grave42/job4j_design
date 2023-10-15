package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithWrongTemplate() {
        String path = "./data/pair_wrong_template.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("id=1");
    }

    @Test
    void whenPairWithWrongTemplate2() {
        String path = "./data/pair_wrong_template2.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> {
            config.load();
        });
    }

    @Test
    void whenPairWithWrongTemplate3() {
        String path = "./data/pair_wrong_template3.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> {
            config.load();
        });
    }
}