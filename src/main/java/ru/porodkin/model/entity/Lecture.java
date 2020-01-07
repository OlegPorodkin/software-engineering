package ru.porodkin.model.entity;

import java.sql.Blob;

public class Lecture {
    private long id;
    private String lectureName;
    private Lecturer lecturer;
    private TypeOfWork typeOfWork;
    private String schedule;
    private String task;
    private Blob resources;

    public Lecture() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Blob getResources() {
        return resources;
    }

    public void setResources(Blob resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lectures{");
        sb.append("lectureName='").append(lectureName).append('\'');
        sb.append(", lecturer=").append(lecturer);
        sb.append(", typeOfWork=").append(typeOfWork);
        sb.append(", schedule='").append(schedule).append('\'');
        sb.append(", task='").append(task).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
