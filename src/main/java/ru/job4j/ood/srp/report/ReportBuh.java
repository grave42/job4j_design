package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportBuh implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final InMemoryCurrencyConverter converter;
    private final Currency currCurrency;
    private final Currency targetCurrency;

    public ReportBuh(Store store, DateTimeParser<Calendar> dateTimeParser, InMemoryCurrencyConverter converter, Currency currCurrency, Currency targetCurrency) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.converter = converter;
        this.currCurrency = currCurrency;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(currCurrency, employee.getSalary(), targetCurrency))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

