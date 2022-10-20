package com.qx.jwt.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.qx.jwt.entity.User;
import com.qx.jwt.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 生成token
 * @author Liz
 */
@Service
public class TokenServiceImpl implements TokenService {
    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    @Override
    public String getToken(User user) {
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        String token= JWT.create().withAudience(user.getId().toString())
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
