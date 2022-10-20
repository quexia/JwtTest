package com.qx.jwt.service;

import com.qx.jwt.entity.User;

/**
 * @author Liz
 */
public interface UserService {

    User getUser(String userName,String password);

    User getUser(Integer id);
}
