package ru.porodkin.model.dao;

import ru.porodkin.model.entity.Department;
import ru.porodkin.model.entity.TypeOfWork;

import java.util.List;

public interface TypeOfWorkDao extends CrudDao<TypeOfWork> {
    List<TypeOfWork> getAll();

    @Override
    int save(TypeOfWork obj);
}
