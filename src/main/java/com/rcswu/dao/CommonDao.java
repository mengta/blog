package com.rcswu.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDao<T> {
    T getById(Serializable id);
    List<T> findAll();
    List<T> findAllEntityByCondition(String condition,int startIndex,int dataNumber);
    void deleteById(Serializable id);
    void update(T t);
    Serializable save(T t);
    void saveOrUpdate(T t);
}
