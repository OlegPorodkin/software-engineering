package ru.porodkin.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.porodkin.model.entity.TypeOfWork;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class TypeOfWorkDaoImpl implements TypeOfWorkDao {

    private static final String SQL_QUERY_GET_ALL = "select * from homeworks.type_of_work";
    private RowMapper<TypeOfWork> rowMapper = (resultSet, i) -> {
        TypeOfWork typeOfWork = new TypeOfWork();

        typeOfWork.setId(resultSet.getLong(1));
        typeOfWork.setTypeWork(resultSet.getString(2));

        return typeOfWork;
    };

    private InitialContext cnt;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TypeOfWork> getAll() {

        List<TypeOfWork> departments = new ArrayList<>();

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
    public int save(TypeOfWork obj) {
        return 0;
    }

    @Override
    public int update(TypeOfWork obj) {
        return 0;
    }

    @Override
    public int delete(TypeOfWork obj) {
        return 0;
    }

    @Override
    public TypeOfWork get(long id) {
        return null;
    }


}
