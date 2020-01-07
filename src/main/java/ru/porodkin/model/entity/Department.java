package ru.porodkin.model.entity;

import org.springframework.jdbc.core.JdbcTemplate;

public class Department {
    private long id;
    private String title;

    public Department() {
    }

    public Department(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Department{");
        sb.append("title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
