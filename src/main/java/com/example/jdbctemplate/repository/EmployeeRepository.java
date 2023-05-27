package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    public Employee getEmployeeById(String empId);
}
