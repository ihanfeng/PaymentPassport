package com.cssweb.common.service;

import com.cssweb.common.domain.BaseDomain;

import java.util.List;

/**
 * Created by chenhf on 14-2-20.
 */
public interface BaseService<T extends BaseDomain> {

    int create(T obj);
    int update(T obj);
    int delete(T obj);

    T get(long id);
    List<T> getAll();

    List<T> getPage(String id, String field, String direction, int pageNo, int pageSize);
    long getTotalRecords();
    long getTotalPages(int pageSize);



}
