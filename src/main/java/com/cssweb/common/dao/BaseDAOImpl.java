package com.cssweb.common.dao;

import com.cssweb.common.domain.BaseDomain;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhf on 14-2-20.
 */
@Repository
public abstract class BaseDAOImpl<T extends BaseDomain> implements BaseDAO<T>{
    protected Class<T> entityClass;
    protected String className;

    private static final String POSTFIX_CREATE = ".create";
    private static final String POSTFIX_UPDATE = ".update";
    private static final String POSTFIX_DELETE = ".delete";
    private static final String POSTFIX_GET = ".get";
    private static final String POSTFIX_GETALL = ".getAll";
    private static final String POSTFIX_GETTOTALRECORDS = ".getTotalRecords";
    private static final String POSTFIX_PAGE = ".getPage";

    protected long totalRecords = 0L;


    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    public BaseDAOImpl()
    {
        entityClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        className = entityClass.getName();
        System.out.println("className=" + entityClass);
    }


    @Override
    public int create(T obj) {
       return sqlSessionTemplate.insert(className + POSTFIX_CREATE, obj);
    }

    @Override
    public int delete(T obj) {
        return sqlSessionTemplate.delete(className + POSTFIX_DELETE, obj);
    }

    @Override
    public int update(T entity) {
        return sqlSessionTemplate.update(className + POSTFIX_UPDATE, entity);
    }



    @Override
    public T get(long id) {

        return sqlSessionTemplate.selectOne(className + POSTFIX_GET, id);
    }

    @Override
    public List<T> getAll() {

        return sqlSessionTemplate.selectList(className + POSTFIX_GETALL);

    }

    @Override
    public long getTotalRecords() {
        totalRecords = 0L;

        totalRecords = sqlSessionTemplate.selectOne(className + POSTFIX_GETTOTALRECORDS);

        return totalRecords;
    }

    @Override
    public long getTotalPages(int pageSize) {
        long totalPages = 0l;

        long totalRecords = getTotalRecords();
        if (totalRecords == 0 || pageSize == 0)
            return totalPages;

        totalPages = totalRecords / pageSize;
        if ( (totalRecords % pageSize) > 0)
            totalPages += 1;

        return totalPages;
    }

    @Override
    public List<T> getPage(String id, String field, String direction, int pageNo, int pageSize) {
        long startPos = 0l;
        long totalPages = getTotalPages(pageSize);

        if (totalPages > pageNo) {
            startPos = (pageNo - 1) * pageSize;
        } else {
            startPos = (totalPages - 1) * pageSize;
        }

        Map params = new HashMap();
        params.put("id", id);
        params.put("field", field);
        params.put("direction", direction);
        params.put("startPos", startPos);
        params.put("pageSize", pageSize);

        System.out.println("id = " + id);
        System.out.println("orderBy = " + field);
        System.out.println("direction = " + direction);
        System.out.println("startPos = " + startPos);
        System.out.println("pageSize = " + pageSize);

        return sqlSessionTemplate.selectList(className + POSTFIX_PAGE, params);
    }
}
