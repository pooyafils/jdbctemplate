package com.example.jdbctemplate.repository;

import org.springframework.web.bind.annotation.RequestParam;

public interface TableInfoRepository {

    public void createTable(String tableName,@RequestParam String[] cloums);
}
