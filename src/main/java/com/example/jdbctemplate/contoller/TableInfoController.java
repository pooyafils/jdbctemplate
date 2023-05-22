package com.example.jdbctemplate.contoller;

import com.example.jdbctemplate.repository.TableInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TableInfoController {
    @Autowired
    TableInfoRepository tableInfoRepository;
    @GetMapping
    public ResponseEntity createTable(@RequestParam String tableName,@RequestParam String[] cloums){

        tableInfoRepository.createTable(tableName,cloums);
        return ResponseEntity.ok("table has been created");
    }
}
