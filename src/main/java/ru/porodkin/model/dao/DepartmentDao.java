package ru.porodkin.model.dao;

import ru.porodkin.model.entity.Department;

import java.util.List;

public interface DepartmentDao extends CrudDao<Department> {

    List<Department> getAll();

    @Override
    int save(Department obj);
}
