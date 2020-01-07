package ru.porodkin.model.dao;

import ru.porodkin.model.entity.Lecture;

import java.util.List;

public interface LectureDao extends CrudDao<Lecture> {
    List<Lecture> getAll();

    @Override
    int save(Lecture obj);
}
