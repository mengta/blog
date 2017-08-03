package com.rcswu.service.impl;

import com.rcswu.dao.CommonDao;
import com.rcswu.service.CommonService;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public abstract class CommonServiceImpl<T> implements CommonService<T> {
    private CommonDao<T> commonDao;

    public CommonDao<T> getCommonDao() {
        return commonDao;
    }

    public void setCommonDao(CommonDao<T> commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public void saveOrUpdate(T t) {
        commonDao.saveOrUpdate(t);
    }

    @Override
    public Serializable saveEntity(T t) {
        return commonDao.save(t);
    }

    @Override
    public void updateEntity(T t) {
        commonDao.update(t);
    }

    @Override
    public void deleteEntityById(Serializable id) {
        commonDao.deleteById(id);
    }

    @Override
    public List<T> findAllEntity() {
        return commonDao.findAll();
    }

    @Override
    public T getEntityById(Serializable id) {
        return (T)commonDao.getById(id);
    }

}
