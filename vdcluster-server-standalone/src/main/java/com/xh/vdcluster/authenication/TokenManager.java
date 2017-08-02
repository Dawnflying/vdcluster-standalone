package com.xh.vdcluster.authenication;

import com.xh.vdcluster.common.DateUtils;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bloom on 2017/7/16.
 */
public class TokenManager {

    private static CopyOnWriteArrayList<Token> tokens = new CopyOnWriteArrayList<>();
    /**
     * 获取口令
     * @param duration 有效时间，单位毫秒
     * @return
     */
    public static Token getToken(int duration){
        String tokenstr = TokenProcessor.generateTokeCode();

        Date expireDate = DateUtils.getFromMills(System.currentTimeMillis()+duration*1000);

        Token token = new Token(tokenstr,expireDate);

        tokens.add(token);

        return token;
    }

    /**
     * 获取口令
     * @return
     */
    public static Token getToken(){
        return getToken(300);
    }

    public static boolean checkTokenExpiration(String token){
        Boolean isValid = false;

        for(Token t: tokens){
            if(t.getTokenString().equalsIgnoreCase(token) && t.getExpireTime().compareTo(DateUtils.getNow()) > 0)
            {
                isValid = true;
            }
        }

        return isValid;
    }
}
