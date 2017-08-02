package com.xh.vdcluster.authenication;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by bloom on 2017/7/16.
 */
 class TokenProcessor {


    public static synchronized String generateTokeCode(){
        String value = System.currentTimeMillis()+new Random().nextInt()+"";
        //获取数据指纹，指纹是唯一的
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = md.digest(value.getBytes());//产生数据的指纹
            //Base64编码
            BASE64Encoder be = new BASE64Encoder();
           return be.encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
