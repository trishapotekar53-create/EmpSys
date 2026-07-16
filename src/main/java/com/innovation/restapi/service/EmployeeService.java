package com.innovation.restapi.service;

import java.util.List;

import com.innovation.restapi.model.Employee;

public interface EmployeeService {

    Employee insert(Employee emp);

    Employee search(int id);

    Employee update(Employee emp);

    List<Employee> getAll();

    void delete(int id);

    // 🔥 ADD THIS
    List<String> getDepartments();
}