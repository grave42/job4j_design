package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReportJsonTest {

    @Test
    public void whenJsonGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Vovka", now, now, 400);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportJson(store, parser);
        JSONArray expected = new JSONArray();
        JSONObject expectedJson = new JSONObject();
        JSONObject expectedJson2 = new JSONObject();
        expectedJson.put("name", worker.getName());
        expectedJson.put("hired", parser.parse(worker.getHired()));
        expectedJson.put("fired", parser.parse(worker.getFired()));
        expectedJson.put("salary", worker.getSalary());
        expectedJson2.put("name", worker2.getName());
        expectedJson2.put("hired", parser.parse(worker2.getHired()));
        expectedJson2.put("fired", parser.parse(worker2.getFired()));
        expectedJson2.put("salary", worker2.getSalary());
        expected.put(expectedJson);
        expected.put(expectedJson2);
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}