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
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportXml(store, parser);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String formattedDate = dateFormat.format(now.getTime());
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <fired>" + formattedDate + "</fired>\n"
                + "        <hired>" + formattedDate + "</hired>\n"
                + "        <name>" + worker.getName() + "</name>\n"
                + "        <salary>" + worker.getSalary() + "</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}