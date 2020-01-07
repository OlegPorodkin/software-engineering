package ru.porodkin.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.porodkin.model.entity.Department;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final String SQL_QUERY_SAVE = "insert into homeworks.department(title) values (?);";
    private final String SQL_QUERY_GET_ALL = "select * " +
                                             "from homeworks.department d";
    private RowMapper<Department> rowMapper = (resultSet, i) -> {
        Department department = new Department();

        department.setId(resultSet.getLong(1));
        department.setTitle(resultSet.getString(2));
        return department;
    };

    private InitialContext cnt;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();

        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);

            departments = jdbcTemplate.query(SQL_QUERY_GET_ALL, rowMapper);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public int save(Department department) {
        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return jdbcTemplate.update(SQL_QUERY_SAVE, department.getTitle());
    }

    @Override
    public int update(Department obj) {
        return 0;
    }

    @Override
    public int delete(Department obj) {
        return 0;
    }

    @Override
    public Department get(long id) {
        return null;
    }
}
