package com.cssweb.idm.service;



import com.cssweb.payment.account.AccountService;
import com.cssweb.payment.account.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chenhf on 2014/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-paymentclient.xml")
public class UserServiceTest {
    @Autowired
    private AccountService accountService;
/*
    @Test
    public void create()
    {
        User user = new User();
        user.setEmail("chenhf2010@qq.com");
        user.setMobilePhone("13918713802");
        user.setLocked(0);
        user.setUserName("anderschen");
        user.setPassword("chf888");
        user.setRealName("陈海峰");


        int ret = accountService.create(user);
        System.out.println("ret = " + ret);

    }

    @Test
    public void update()
    {
        List<User> users = userService.getAll();

        for (User user : users) {

            user.setEmail("chenhf@outlook.com");

            int ret = userService.update(user);
            System.out.println("ret = " + ret);
        }
    }

    @Test
    public void getTotalRecords()
    {
        long ret = userService.getTotalRecords();
        System.out.println("ret = " + ret);
    }

    @Test
    public void get()
    {
        List<User> users = userService.getAll();

        for (User user : users) {

            User tmp = userService.get(user.getUserId());


            System.out.println("userid = " + tmp.getUserId() + ", username=" + tmp.getUserName());
        }
    }

    @Test
    public void login()
    {
        User user = userService.login("chenhf", "chf888");
    }

    @Test
    public void getTotalPages()
    {

        long ret = userService.getTotalPages(1);
        System.out.println("ret = " + ret);
    }

    @Test
    public void page()
    {
        int pageSize = 1;
        long totalPages = userService.getTotalPages(pageSize);
        for (int i=1; i<=totalPages; i++) {
            System.out.println("第" + i + "页");
            List<User> users = userService.getPage("1", "userid", "desc", i, pageSize);
            //List<User> users = userService.getPage(null, null, null, i, pageSize);
            if (users == null)
            {
                    System.out.println("没有数据。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
            }

            for (User user : users) {
                System.out.println("。。。。。。。。。。。。。。。。。。。。。。有数据。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
                System.out.println("userid = " + user.getUserId() + ", userName=" + user.getUserName());
            }
        }
    }
    */
}
