package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReportXmlTest {

    @Test
    public void whenXmlGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 500);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportXml(store, parser);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <fired>" + parser.parse(worker.getFired()) + "</fired>\n"
                + "        <hired>" + parser.parse(worker.getHired()) + "</hired>\n"
                + "        <name>" + worker.getName() + "</name>\n"
                + "        <salary>" + worker.getSalary() + "</salary>\n"
                + "    </employee>\n"
                + "    <employee>\n"
                + "        <fired>" + parser.parse(worker.getFired()) + "</fired>\n"
                + "        <hired>" + parser.parse(worker.getHired()) + "</hired>\n"
                + "        <name>" + worker2.getName() + "</name>\n"
                + "        <salary>" + worker2.getSalary() + "</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}