package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.Token;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.service.TokenService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by bloom on 2017/7/24.
 */
@Component
public class TokenServiceImpl implements TokenService {

    private static ConcurrentMap<String, Token> tokenConcurrentMap = new ConcurrentHashMap<>();

    @Override
    public int validate(String id, String token) {

        if(!tokenConcurrentMap.containsKey(id))
            return VdResultErrorCode.TOKEN_ERROR;

        if(!tokenConcurrentMap.get(id).getTokenString().equalsIgnoreCase(token))
            return VdResultErrorCode.TOKEN_ERROR;

        return VdResultErrorCode.TOKEN_SUCCESS;
    }

    @Override
    public void addToken(String id, Token token) {
        tokenConcurrentMap.put(id, token);
    }
}
