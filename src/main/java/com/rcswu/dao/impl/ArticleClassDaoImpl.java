package com.rcswu.dao.impl;

import com.rcswu.dao.ArticleClassDao;
import com.rcswu.domain.ArticleClass;

import java.io.Serializable;
import java.util.List;

public class ArticleClassDaoImpl extends CommonDaoImpl<ArticleClass> implements ArticleClassDao{
    @Override
    public ArticleClass getById(Serializable id) {
        return null;
    }

    @Override
    public List<ArticleClass> findAll() {
        return null;
    }

    @Override
    public List<ArticleClass> findAllEntityByCondition(String condition, int startIndex, int dataNumber) {
        return null;
    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void update(ArticleClass articleClass) {

    }

    @Override
    public Serializable save(ArticleClass articleClass) {
        return null;
    }

    @Override
    public void saveOrUpdate(ArticleClass articleClass) {

    }
}
