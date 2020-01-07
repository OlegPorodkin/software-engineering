package ru.porodkin.model.entity;

public class TypeOfWork {
    private long id;
    private String typeWork;

    public TypeOfWork() {
    }

    public TypeOfWork(String typeWork) {
        this.typeWork = typeWork;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(String typeWork) {
        this.typeWork = typeWork;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TypeOfWork{");
        sb.append("typeWork='").append(typeWork).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
