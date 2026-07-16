package com.innovation.restapi.service;

import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    @Override
    public String getResponse(String msg) {

        msg = msg.toLowerCase();

        if (msg.contains("salary")) {
            return "SQL: SELECT MAX(salary) FROM employee;";
        }
        else if (msg.contains("employee")) {
            return "SQL: SELECT COUNT(*) FROM employee;";
        }
        else if (msg.contains("department")) {
            return "SQL: SELECT * FROM department;";
        }
        else {
            return "Try: salary / employee / department";
        }
    }
}