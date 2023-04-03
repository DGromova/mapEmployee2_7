package com.example.mapemployee2_7.service;

import com.example.mapemployee2_7.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
    Map<String, Employee> all();

}
