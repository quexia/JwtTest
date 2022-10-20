package com.qx.jwt.service;

import com.qx.jwt.entity.User;

/**
 * @author Liz
 */
public interface TokenService {


    public String getToken(User user) ;
}
