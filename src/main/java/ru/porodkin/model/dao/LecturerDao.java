package ru.porodkin.model.dao;

import ru.porodkin.model.entity.Lecturer;

import java.util.List;

public interface LecturerDao extends CrudDao<Lecturer> {

    List<Lecturer> getAll();

}
