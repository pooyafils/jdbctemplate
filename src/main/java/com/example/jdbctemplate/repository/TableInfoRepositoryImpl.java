package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository

public class TableInfoRepositoryImpl extends JdbcDaoSupport  implements  TableInfoRepository {
    @Autowired
    private DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
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
            getJdbcTemplate();
        }
        qu+=")";
        System.out.println(qu);
       // jdbcTemplate.execute("create table USERS ( id integer , name varchar(60), age integer, salary decimal )");
         jdbcTemplate.execute(qu);

    }

    @Override
    public TableInfo tableExits(String name) {
        String sql = "SELECT if (count(t.TABLE_CATALOG)>0 , 'YES','no') as 'result'FROM information_schema.tables t WHERE table_schema = 'jdbctemplate' AND table_name = 'users'LIMIT 1 ;";
        return (TableInfo) getJdbcTemplate().queryForObject(sql, new Object[]{name}, new RowMapper<TableInfo>() {
            @Override
            public TableInfo mapRow(ResultSet rs, int rwNumber) throws SQLException {
                TableInfo emp = new TableInfo();
                boolean b = rs.getRow() > 0;
                System.out.println(b);
                return emp;
            }
        });

    }
}
