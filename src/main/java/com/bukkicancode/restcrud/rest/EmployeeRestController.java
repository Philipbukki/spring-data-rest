package com.bukkicancode.restcrud.rest;

import com.bukkicancode.restcrud.entity.Employee;
import com.bukkicancode.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
       return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee  employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("No employee found with id - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);

    }

    @DeleteMapping("employees/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw  new RuntimeException("Not found employee with id- " +employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee with id - "+employeeId;

    }


}
