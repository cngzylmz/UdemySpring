package com.udemy.spring.rest;

import com.udemy.spring.entity.Employee;
import com.udemy.spring.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id not found -> " + id);
        }
        return employee;
    }

    @PostMapping("/employees/save")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PostMapping("/employees/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee not found -> " + id);
        }

        employeeService.delete(id);
        return "Employee " + id + " deleted";
    }
}
