package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl extends JdbcDaoSupport implements EmployeeRepository {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee " +
                "(empId, empName) VALUES (?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                emp.getEmpId(), emp.getEmpName()
        });

    }

    @Override
    public void insertEmployees(List<Employee> employees) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<Employee>();
        for(Map<String, Object> row:rows){
            Employee emp = new Employee();
            emp.setEmpId((String)row.get("empId"));
            emp.setEmpName((String)row.get("empName"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public void getEmployeeById(String empid) {

    }
}
