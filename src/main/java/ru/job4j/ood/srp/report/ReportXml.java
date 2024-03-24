package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXml implements Report {

    private final Store store;

    private final DateTimeParser<Calendar> dateTimeParser;

    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";


    public ReportXml(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;

    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        Employees employees = new Employees();
        employees.setEmployeeList(store.findBy(filter));

        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(employees, writer);

        return writer.toString();
    }
}

