package com.example.jdbctemplate.model;

public class TableInfo {
    private String tableName;

    public TableInfo() {
    }

    public TableInfo(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
