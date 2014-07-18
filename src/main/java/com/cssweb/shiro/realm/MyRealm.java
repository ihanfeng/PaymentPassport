package com.cssweb.shiro.realm;



import com.cssweb.payment.account.AccountService;
import com.cssweb.payment.account.CsswebException;
import com.cssweb.payment.account.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;



    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*
        //获取登录时输入的用户名
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();

        //到数据库查是否有此对象
        User user=userService.findByName(loginName);

        if (user!=null)
        {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            //用户的角色集合
            info.setRoles(user.getRolesName());

            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            List<Role> roleList = user.getRoleList();

            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionsName());
            }
            return info;
        }
*/
        return null;
    }

    /**
     * 登录认证;
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //查出是否有此用户
        User user = null;
        try {
            user = accountService.login(token.getUsername(), "chf888", "");
            user.setUserName("chenhf");
            user.setPassword("chf888");
        } catch (CsswebException e) {
            e.printStackTrace();
        }

        if (user != null)
        {
            //若存在，将此用户存放到登录认证info中
            System.out.println("认证成功============");
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        }
        else
        {
            System.out.println("认证失败============");
        }

        return null;
    }

}