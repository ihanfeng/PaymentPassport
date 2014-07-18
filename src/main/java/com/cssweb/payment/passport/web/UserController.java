package com.cssweb.payment.passport.web;

/**
 * Created by chenhf on 2014/7/18.
 */
import javax.servlet.http.HttpServletRequest;


import com.cssweb.payment.account.AccountService;
import com.cssweb.payment.account.CsswebException;
import com.cssweb.payment.account.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController  {

    @Autowired
    private AccountService accountService;



    @RequestMapping(value = "/login/login.do")
    public ModelAndView login(HttpServletRequest request, LoginCommand loginCommand){

        System.out.println("username=" + loginCommand.getUserName());
        System.out.println("password=" + loginCommand.getPassword());

        User user = null;
        try {
            user = accountService.login(loginCommand.getUserName(), loginCommand.getPassword(), "");
        } catch (CsswebException e) {
            e.printStackTrace();
        }

        if (user != null)
        {
            System.out.println("userService.login is successfull");
            // request.getSession().setAttribute("user", user);
            //  return new ModelAndView("main");

        }
        else
        {
            return new ModelAndView("/login/login.jsp", "error", "用户名或密码错误。");
        }


        UsernamePasswordToken token = new UsernamePasswordToken(loginCommand.getUserName(), loginCommand.getPassword());
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try
        {
            currentUser.login(token);

            request.getSession().setAttribute("user", user);
System.out.println("开始跳转");

            return new ModelAndView("/main/main.jsp");
        }
        catch(UnknownAccountException uae)
        {
            System.out.println("未知账户");
            return new ModelAndView("/login/login.jsp", "error", "未知账户");
        }
        catch(IncorrectCredentialsException ice)
        {
            System.out.println("密码不正确");
            return new ModelAndView("/login/login.jsp", "error", "密码不正确");
        }
        catch(LockedAccountException lae)
        {
            System.out.println("账户已锁定");
            return new ModelAndView("/login/login.jsp", "error", "账户已锁定");
        }
        catch(ExcessiveAttemptsException eae)
        {
            System.out.println("用户名或密码错误次数过多");
            return new ModelAndView("/login/login.jsp", "error", "用户名或密码错误次数过多");
        }
        catch(AuthenticationException  ae)
        {
            System.out.println("用户名或密码不正确");
            return new ModelAndView("/login/login.jsp", "error", "用户名或密码不正确");
        }



    }

    @RequestMapping(value = "/logout.do")
    public String logout(){
       /* Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
        HttpSession session = request.getSession(false);
        if( session != null ) {
            session.invalidate();
        }
        */
        return "/login/login.jsp";

    }
}