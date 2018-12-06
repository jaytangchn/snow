package com.jaytang.config.model;

import com.jaytang.mapper.UserMapper;
import com.jaytang.model.Role;
import com.jaytang.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义身份认证realm
 */
public class CustomRealm extends AuthorizingRealm {

    private UserMapper userMapper;

    @Autowired
    private void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /**
     * 获取授权信息，权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName =(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo
                = new SimpleAuthorizationInfo();

        User user = new User();
        user.setName(userName);
        //根据用户名获取角色
        List<Role>  rolesList = userMapper.getRoles(user);

        Set<String> roles = rolesList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    /**
     * 获取身份验证信息
     * shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String passWord = userMapper.getPwd(usernamePasswordToken.getUsername());
        if(null == passWord){
            throw new SnowException("密码不能为空");
        }else if(!passWord.equals(new String((char [] )usernamePasswordToken.getCredentials()))){
            throw new SnowException("密码错误");
        }
        return new SimpleAuthenticationInfo(usernamePasswordToken.getPrincipal(),passWord,getName());
    }
}
