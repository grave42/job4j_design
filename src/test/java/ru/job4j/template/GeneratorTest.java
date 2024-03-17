package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
public class GeneratorTest {

    public static final String TEMPLATE = "I am a ${name}, Who are ${subject}?";

    @Test
    public void getExceptedString() {
        String exceptedString = "I am a Filipp, Who are you?";
        Generator generator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Filipp");
        args.put("subject", "you");
        String resultStr = generator.produce(TEMPLATE, args);
        assertEquals(exceptedString, resultStr);
    }

    @Test
    public void testProduceMissingKey() {
        Generator generator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(TEMPLATE, args));
    }

    @Test
    public void testProduceExtraKey() {
        Generator generator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("extra", "value");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(TEMPLATE, args));

    }
}