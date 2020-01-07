package ru.porodkin.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.porodkin.model.entity.Department;
import ru.porodkin.model.entity.Lecturer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class LecturerDaoImpl implements LecturerDao {

    private static final String SQL_QUERY_GET_ALL = "select * " +
                                                    "from homeworks.lecturer l " +
                                                    "left join homeworks.department d on l.department = d.id";
    private static final String SQL_QUERY_SAVE = "insert into homeworks.lecturer(fullname, tel, department, status) values (?,?,?,?);";
    private RowMapper<Lecturer> rowMapper = (resultSet, i) -> {
        Lecturer lecturer = new Lecturer();
        Department department = new Department();
        department.setId(resultSet.getLong(6));
        department.setTitle(resultSet.getString(7));

        lecturer.setId(resultSet.getLong(1));
        lecturer.setFullName(resultSet.getString(2));
        lecturer.setTelephone(resultSet.getString(3));
        lecturer.setDepartment(department);
        lecturer.setStatus(resultSet.getString(5));

        return lecturer;
    };

    private InitialContext cnt;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Lecturer> getAll() {
        List<Lecturer> lecturers = new ArrayList<>();

        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);

            lecturers = jdbcTemplate.query(SQL_QUERY_GET_ALL, rowMapper);

        } catch (NamingException e) {
            e.printStackTrace();
        }

        return lecturers;
    }

    @Override
    public int save(Lecturer lecturer) {
        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return jdbcTemplate.update(SQL_QUERY_SAVE, lecturer.getFullName(),
                                                    lecturer.getTelephone(),
                                                    lecturer.getDepartment().getId(),
                                                    lecturer.getStatus());
    }

    @Override
    public int update(Lecturer obj) {
        return 0;
    }

    @Override
    public int delete(Lecturer obj) {
        return 0;
    }

    @Override
    public Lecturer get(long id) {
        return null;
    }
}
