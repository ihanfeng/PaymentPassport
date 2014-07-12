package com.cssweb.idm.dao;

import com.cssweb.common.dao.BaseDAO;
import com.cssweb.common.dao.BaseDAOImpl;
import com.cssweb.idm.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by chenhf on 14-2-21.
 */
@Repository
public class UserDAO extends BaseDAOImpl<User> {

    public User login(String userName, String password)
    {
        HashMap params = new HashMap();
        params.put("userName", userName);
        params.put("password", password);

        String statement = "com.cssweb.idm.domain.User.login";
        System.out.println("statemtnt=" + statement);

        User user = new User();
        System.out.println("sqlSessionTemplate=" +sqlSessionTemplate.toString());
        user = sqlSessionTemplate.selectOne(statement, params);

        //user = new User();
        //user.setUserName("chf");
        //    user.setPassword("chf888");
        if (user == null)
        {
            System.out.println("UserDao user is null");
        }
        else
        {
            System.out.println("username " + user.getUserName());
        }

        return user;
    }
}
