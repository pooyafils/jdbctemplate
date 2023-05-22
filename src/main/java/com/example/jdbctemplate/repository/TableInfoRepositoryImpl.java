package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class TableInfoRepositoryImpl implements TableInfoRepository {

      @Autowired
     private JdbcTemplate jdbcTemplate;
    @Override
    public void createTable(String tableName, String[] cloums) {
        System.out.println(cloums.length);
        String qu="create table "+tableName+"(";
        for(int i=0;i<cloums.length;i++){
            qu += cloums[i] ;
            if(i<cloums.length-1) {
                qu += ",";
            }
        }
        qu+=")";
        System.out.println(qu);
       // jdbcTemplate.execute("create table USERS ( id integer , name varchar(60), age integer, salary decimal )");
         jdbcTemplate.execute(qu);

    }


}
