package com.xh.vdcluster.authenication;

import java.util.Date;

/**
 * Created by bloom on 2017/7/16.
 */
public class Token {

    private String tokenString;

    private Date expireTime;

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Token(String tokenString, Date expireTime) {
        this.tokenString = tokenString;
        this.expireTime = expireTime;
    }
}
