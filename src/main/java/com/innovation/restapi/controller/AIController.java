package com.innovation.restapi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://empsys-ruby.vercel.app")
@RequestMapping("/ai")
public class AIController {

    @PostMapping("/ask")
    public Map<String, String> askAI(@RequestBody Map<String, String> request) {

        // ✅ SAFE NULL CHECK (IMPORTANT FIX)
        String msg = request.get("message");

        if (msg == null || msg.trim().isEmpty()) {
            return Map.of("answer", "Please send message like: highest salary / employee count / department");
        }

        msg = msg.toLowerCase();

        String response;

        // SIMPLE AI LOGIC
        if (msg.contains("highest salary")) {
            response = "Use SQL: SELECT MAX(salary) FROM employee;";
        }
        else if (msg.contains("how many employees") || msg.contains("employee count")) {
            response = "Use SQL: SELECT COUNT(*) FROM employee;";
        }
        else if (msg.contains("department")) {
            response = "Departments are stored in department table and linked with employee table.";
        }
        else if (msg.contains("salary")) {
            response = "You can calculate salary using aggregation queries like AVG, MAX, MIN.";
        }
        else {
            response = "Sorry, I don't understand. Try: highest salary / employee count / department";
        }

        return Map.of("answer", response);
    }
}