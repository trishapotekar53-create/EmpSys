package com.innovation.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.restapi.model.Employee;
import com.innovation.restapi.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")public class EmployeeController {

    @Autowired
    private EmployeeService es;

    // ✅ GET ALL EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return es.getAll();
    }

    // ✅ ADD EMPLOYEE
    @PostMapping("/employees")
    public Employee insert(@RequestBody Employee emp) {
        return es.insert(emp);
    }

    // ✅ GET BY ID
    @GetMapping("/employees/{id}")
    public Employee search(@PathVariable("id") int id) {
        return es.search(id);
    }

    // ✅ UPDATE EMPLOYEE
    @PutMapping("/employees/{id}")
    public Employee update(@PathVariable("id") int id, @RequestBody Employee em) {
        em.setId(id);
        return es.update(em);
    }

    // ✅ DELETE EMPLOYEE
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        es.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 🔥 NEW FEATURE (DOES NOT BREAK ANYTHING)
    @GetMapping("/employees/departments")
    public List<String> getDepartments() {
        return es.getDepartments();
    }
}