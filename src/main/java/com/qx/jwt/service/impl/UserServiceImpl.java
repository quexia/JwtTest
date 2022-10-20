package com.qx.jwt.service.impl;

import com.qx.jwt.entity.User;
import com.qx.jwt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String userName, String password) {
        if ("admin".equals(userName) && "admin".equals(password)) {
            User user = new User();
            user.setId(0);
            user.setUserName("admin");
            user.setPassword("admin");
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUser(Integer id) {
        if (id == 0 ){
            User user=new User();
            user.setId(0);
            user.setUserName("admin");
            user.setPassword("admin");
            return user;
        }
        else{
            return null;
        }
    }
}
