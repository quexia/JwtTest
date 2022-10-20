package com.qx.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.qx.jwt.annotation.LoginToken;
import com.qx.jwt.entity.User;
import com.qx.jwt.service.TokenService;
import com.qx.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liz
 */
@RestController
public class MessageController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    public Object login(String username, String password){
        JSONObject jsonObject=new JSONObject();
        User user=userService.getUser(username, password);
        if(user==null){
            jsonObject.put("message","登录失败！");
            return jsonObject;
        }else {
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            return jsonObject;
        }
    }

    @LoginToken
    @PostMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";

    }
}
