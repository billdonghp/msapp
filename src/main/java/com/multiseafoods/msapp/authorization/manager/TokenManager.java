package com.multiseafoods.msapp.authorization.manager;

import com.multiseafoods.msapp.authorization.model.TokenModel;

/**
 *
 * Author : Haipeng Dong
 */
public interface TokenManager {
    /**
     * 创建Token
     * @param username
     * @return
     */
    public TokenModel createToken(String username);

    /**
     * 获取Model
     * @param authorization
     * @return
     */
    public TokenModel getToken(String authorization);

    public boolean checkToken(TokenModel model);

    public void deleteToken(String username);
}
