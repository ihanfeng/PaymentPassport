package com.cssweb.common.service;

import com.cssweb.common.dao.BaseDAO;
import com.cssweb.common.domain.BaseDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhf on 14-2-20.
 */
@Service
public abstract class BaseServiceImpl<T extends BaseDomain>  implements BaseService<T> {

    /*
    Spring4新特性——泛型限定式依赖注入
    http://jinnianshilongnian.iteye.com/blog/1989330
     */

/*
    protected BaseDAO<T> baseDAO;

    public BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }
    public void setBaseDAO(BaseDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }
*/

    @Autowired
    protected BaseDAO<T> baseDAO;

    @Override
    public int create(T obj) {
        return baseDAO.create(obj);
    }
    @Override
    public int update(T obj) {
        return baseDAO.update(obj);
    }
    @Override
    public int delete(T obj) {
        return baseDAO.delete(obj);
    }

    @Override
    public T get(long id) {
        return baseDAO.get(id);
    }
    @Override
    public List<T> getAll() {
        return baseDAO.getAll();
    }


    @Override
    public long getTotalRecords() {
        return baseDAO.getTotalRecords();
    }
    @Override
    public long getTotalPages(int pageSize) {
        return baseDAO.getTotalPages(pageSize);
    }

    @Override
    public List<T> getPage(String id, String field, String direction, int pageNo, int pageSize) {
        return baseDAO.getPage(id, field, direction, pageNo, pageSize);
    }
}
