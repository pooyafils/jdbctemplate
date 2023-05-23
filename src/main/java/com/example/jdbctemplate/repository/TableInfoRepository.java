package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.TableInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface TableInfoRepository {

    public void createTable(String tableName,@RequestParam String[] cloums);
    public TableInfo tableExits(String name);
}
