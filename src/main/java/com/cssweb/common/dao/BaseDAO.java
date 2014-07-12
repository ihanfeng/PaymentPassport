package com.cssweb.common.dao;

import com.cssweb.common.domain.BaseDomain;

import java.util.List;

/**
 * Created by chenhf on 14-2-20.
 */
public interface BaseDAO<T extends BaseDomain> {
    // CRUD

    int create(T entity);
    int update(T entity);
    int delete(T entity);

    T get(long id);
    List<T> getAll();

    List<T> getPage(String id, String field, String direction, int pageNo, int pageSize);
    long getTotalRecords();
    long getTotalPages(int pageSize);
}
