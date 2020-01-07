package ru.porodkin.model.dao;

public interface CrudDao<T> {
    int save(T obj);

    int update(T obj);

    int delete(T obj);

    T get(long id);
}
