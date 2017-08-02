package com.xh.vdcluster.service;

import com.xh.vdcluster.authenication.Token;

/**
 * Created by bloom on 2017/7/16.
 */
public interface TokenService {

    int validate(String id, String token);


    void addToken(String id, Token token);
}
