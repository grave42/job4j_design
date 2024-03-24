package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {
    private List<Employee> employeeList;

    public Employees() {
    }

    public Employees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlElement(name = "employee")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
