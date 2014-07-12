package com.cssweb.idm.service;


import com.cssweb.common.service.BaseServiceImpl;
import com.cssweb.idm.dao.UserDAO;


import com.cssweb.idm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("userService")
public class UserService extends BaseServiceImpl<User>{
    
	@Autowired
	private UserDAO userDao;
    //private UserDaoMapper userDaoMapper;
	

    /*
    判断用户是否已存在
     */
    public boolean isUserExist(String userName)
    {
        return false;
    }

    /*
    注册用户
     */
    public boolean registerUser(User user)
    {
        return false;
    }

    /*
    用户登录
     */
    public User login(String userName, String password)
    {

        return userDao.login(userName, password);
    }



}
