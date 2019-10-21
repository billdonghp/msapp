package com.multiseafoods.msapp.authorization.manager.impl;

import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.authorization.model.TokenModel;
import com.multiseafoods.msapp.utils.JasyptUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Component
public class RedisTokenManager implements TokenManager {
    private Map<String,String> redis = new HashMap<String, String>();

    @Override
    public TokenModel createToken(String username) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        TokenModel model = new TokenModel(username,uuid);

        redis.put(username, model.toString());
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

        String token = redis.get(model.getUsername());

        if(token == null || !token.equals(model.toString())){
            return false;
        }
        return true;
    }

    @Override
    public void deleteToken(String username) {
        redis.remove(username);

    }
}
