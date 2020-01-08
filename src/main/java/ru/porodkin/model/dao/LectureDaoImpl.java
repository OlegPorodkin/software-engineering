package ru.porodkin.model.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.porodkin.model.entity.Department;
import ru.porodkin.model.entity.Lecture;
import ru.porodkin.model.entity.Lecturer;
import ru.porodkin.model.entity.TypeOfWork;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class LectureDaoImpl implements LectureDao {

    private static final String SQL_QUERY_SAVE = "insert into homeworks.lectures(lecture_name, lecturer, type_of_work, schedule, task, resources) values (?,?,?,?,?,?);";
    private static final String SQL_QUERY_UPDATE = "update homeworks.lectures set lecture_name = ?, lecturer = ?, type_of_work = ?, schedule = ?, task = ?, resources = ? where id = ?;";
    private static final String SQL_QUERY_GET_ALL = "select * " +
                                                    "from homeworks.lectures lectures " +
                                                    "         join homeworks.lecturer lecturer on lectures.lecturer = lecturer.id " +
                                                    "         join homeworks.type_of_work type_of_w on lectures.type_of_work = type_of_w.id " +
                                                    "         join homeworks.department depart on lecturer.department= depart.id;";
    private static final String SQL_QUERY_GET_LECTURE = "select * " +
                                                        "from homeworks.lectures lectures " +
                                                        "         join homeworks.lecturer lecturer on lectures.lecturer = lecturer.id " +
                                                        "         join homeworks.type_of_work type_of_w on lectures.type_of_work = type_of_w.id " +
                                                        "         join homeworks.department depart on lecturer.department= depart.id " +
                                                        "where lectures.id = ? ;";

    private RowMapper<Lecture> rowMapper = (resultSet, i) -> {
        Lecture lecture = new Lecture();

        Department d = new Department();
        d.setId(resultSet.getLong(15));
        d.setTitle(resultSet.getString(16));

        TypeOfWork t = new TypeOfWork();
        t.setId(resultSet.getLong(13));
        t.setTypeWork(resultSet.getString(14));

        Lecturer l = new Lecturer();
        l.setId(resultSet.getLong(8));
        l.setFullName(resultSet.getString(9));
        l.setTelephone(resultSet.getString(10));
        l.setDepartment(d);
        l.setStatus(resultSet.getString(12));

        lecture.setId(resultSet.getLong(1));
        lecture.setLectureName(resultSet.getString(2));
        lecture.setLecturer(l);
        lecture.setTypeOfWork(t);
        lecture.setSchedule(resultSet.getString(5));
        lecture.setTask(resultSet.getString(6));
        lecture.setResources(resultSet.getBlob(7));

        return lecture;
    };

    private InitialContext cnt;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Lecture> getAll() {

        List<Lecture> lectures = new ArrayList<>();

        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
            lectures = jdbcTemplate.query(SQL_QUERY_GET_ALL, rowMapper);

        } catch (NamingException e) {
            e.printStackTrace();
        }

        if (lectures != null) {
            return lectures;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public int save(Lecture lecture) {
        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return jdbcTemplate.update(SQL_QUERY_SAVE, lecture.getLectureName(),
                                                    lecture.getLecturer().getId(),
                                                    lecture.getTypeOfWork().getId(),
                                                    lecture.getSchedule(),
                                                    lecture.getTask(),
                                                    lecture.getResources());
    }

    @Override
    public int update(Lecture lecture) {
        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return jdbcTemplate.update(SQL_QUERY_UPDATE, lecture.getLectureName(),
                                                    lecture.getLecturer().getId(),
                                                    lecture.getTypeOfWork().getId(),
                                                    lecture.getSchedule(),
                                                    lecture.getTask(),
                                                    lecture.getResources(),
                                                    lecture.getId());
    }

    @Override
    public int delete(Lecture obj) {
        return 0;
    }

    @Override
    public Lecture get(long id) {
        Lecture lecture = new Lecture();
        try {
            cnt = new InitialContext();
            dataSource = (DataSource) cnt.lookup("java:/comp/env/jdbc/postgres");
            jdbcTemplate = new JdbcTemplate(dataSource);
            lecture = jdbcTemplate.queryForObject(SQL_QUERY_GET_LECTURE, new Object[]{id}, rowMapper);

        } catch (NamingException e) {
            e.printStackTrace();
        }

        return lecture;
    }
}
