package com.multiseafoods.msapp.authorization.manager.impl;

import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.authorization.model.TokenModel;
import com.multiseafoods.msapp.utils.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTokenManager implements TokenManager {

    private final StringRedisTemplate redis;
    @Autowired
    public RedisTokenManager(StringRedisTemplate redis) {
        this.redis = redis;
    }

    @Override
    public TokenModel createToken(String username) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        TokenModel model = new TokenModel(username,uuid);
        redis.boundValueOps(username).set(uuid, Contents.TOKEN_EXPIRE,TimeUnit.HOURS);

        return model;
    }

    @Override
    public TokenModel getToken(String authorization) {
        if(authorization == null || authorization.length() == 0){
            return null;
        }
        String[] params = authorization.split("-");
        if(params.length != 2){
            return null;
        }
        String username = params[0];
        String uuid = params[1];
        TokenModel model = new TokenModel(username,uuid);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if(model == null ){
            return false;
        }

        String token = redis.boundValueOps(model.getUsername()).get();

        if(token == null || !token.equals(model.getToken())){
            return false;
        }
        redis.boundValueOps(model.getUsername()).expire(Contents.TOKEN_EXPIRE, TimeUnit.HOURS);
        return true;
    }

    @Override
    public void deleteToken(String username) {
        redis.delete(username);

    }
}
