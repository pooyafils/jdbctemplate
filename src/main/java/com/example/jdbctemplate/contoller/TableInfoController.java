package com.example.jdbctemplate.contoller;

import com.example.jdbctemplate.model.Employee;
import com.example.jdbctemplate.repository.EmployeeRepository;
import com.example.jdbctemplate.repository.TableInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TableInfoController {
    Logger logger =  LoggerFactory.getLogger(TableInfoController.class);

    @Autowired
    TableInfoRepository tableInfoRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/t")
    public ResponseEntity createTable(){
        logger.info("loggggggggggggggggggggggggginf");
        return ResponseEntity.ok("table has been created");
    }
    @GetMapping
    public ResponseEntity createTable(@RequestParam String tableName,@RequestParam String[] cloums){
logger.info("loggggggggggggggggggggggggginf");
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

    @GetMapping("/id")
    public ResponseEntity findById(@RequestParam int id){
      Employee e=  employeeRepository.getEmployeeById(String.valueOf(id));
      e.getEmpId();
        return new ResponseEntity<>(employeeRepository.getEmployeeById(String.valueOf(id)), HttpStatus.ACCEPTED);
    }
}
