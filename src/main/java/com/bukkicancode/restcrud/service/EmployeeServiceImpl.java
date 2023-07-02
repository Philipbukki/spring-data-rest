package com.bukkicancode.restcrud.service;

import com.bukkicancode.restcrud.dao.EmployeeRepository;
import com.bukkicancode.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;

    }
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empId) {

        Optional<Employee>  result= employeeRepository.findById(empId);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();

        }else{
            throw new RuntimeException("Not found employee with id - "+ empId);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;

    }
    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);

    }
}
