package com.cssweb.idm.web;

import javax.servlet.http.HttpServletRequest;


import com.cssweb.common.web.BaseControllerImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cssweb.idm.domain.User;
import com.cssweb.idm.service.UserService;

@Controller
public class UserController extends BaseControllerImpl {
	
	@Autowired
	private UserService userService;
    

	
	@RequestMapping(value = "/login/login.do")
	public ModelAndView login(HttpServletRequest request, LoginCommand loginCommand){

        System.out.println("username=" + loginCommand.getUserName());
        System.out.println("password=" + loginCommand.getPassword());

        User user = userService.login(loginCommand.getUserName(), loginCommand.getPassword());
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

            return new ModelAndView("/main/main.jsp");
        }
        catch(UnknownAccountException uae)
        {
            return new ModelAndView("/login/login.jsp", "error", "未知账户");
        }
        catch(IncorrectCredentialsException ice)
        {
            return new ModelAndView("/login/login.jsp", "error", "密码不正确");
        }
        catch(LockedAccountException lae)
        {
            return new ModelAndView("/login/login.jsp", "error", "账户已锁定");
        }
        catch(ExcessiveAttemptsException eae)
        {
            return new ModelAndView("/login/login.jsp", "error", "用户名或密码错误次数过多");
        }
        catch(AuthenticationException  ae)
        {
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
