package com.jaytang.app.controller;

import com.jaytang.model.ResultData;
import com.jaytang.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    @GetMapping("/admin")
    public ResultData admin(){
        return ResultData.success().msg("您拥有用户权限，可以获得该接口的信息！");
    }

    @GetMapping("/logout")
    public ResultData logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultData.success().msg("成功退出");
    }

    @GetMapping("/login")
    public ResultData login( User user){
        ResultData resultData = ResultData.success();
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        subject.login(token);
        resultData.setMsg("登录成功");
        return resultData;
    }
}
