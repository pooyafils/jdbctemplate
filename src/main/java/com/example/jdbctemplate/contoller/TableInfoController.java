package com.example.jdbctemplate.contoller;

import com.example.jdbctemplate.model.Employee;
import com.example.jdbctemplate.repository.EmployeeRepository;
import com.example.jdbctemplate.repository.TableInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TableInfoController {
    @Autowired
    TableInfoRepository tableInfoRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping
    public ResponseEntity createTable(@RequestParam String tableName,@RequestParam String[] cloums){

        tableInfoRepository.createTable(tableName,cloums);
        return ResponseEntity.ok("table has been created");
    }
    @GetMapping("/tableFind")
    public ResponseEntity tableExits(@RequestParam String tableName){

        return ResponseEntity.ok(tableInfoRepository.tableExits(tableName));

    }
    @PostMapping
    public ResponseEntity insertEmpolyee(@RequestBody Employee emp){
        employeeRepository.insertEmployee(emp);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeRepository.getAllEmployees(), HttpStatus.ACCEPTED);
    }
}
