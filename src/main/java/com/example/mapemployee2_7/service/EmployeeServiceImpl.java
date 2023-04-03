package com.example.mapemployee2_7.service;

import com.example.mapemployee2_7.Employee;
import com.example.mapemployee2_7.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeesMap = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
            employeesMap.putIfAbsent(lastName + " " + firstName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsValue(employee)) {
            employeesMap.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + employee + " не найден ");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsValue(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + employee + " не найден");
        }
    }

    @Override
    public Map<String, Employee> all() {
        return Map.copyOf(employeesMap);
    }
}
