package com.cssweb.idm.dao;

import com.cssweb.idm.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by chenhf on 13-12-8.
 */
@Repository
public interface UserDaoMapper {
    public int getMatchCount(String userName, String password);
    public User findUserByUserName(final String userName);
    public void updateLoginInfo(User user);
}
