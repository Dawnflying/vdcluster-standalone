package com.xh.vdcluster.common;

import java.util.List;

/**
 * Created by bloom on 2017/7/31.
 */
public class ByteUtils {


    public static byte[] intToByteArray(int value){
        return new byte[]{(byte)((value>>24)&0xff),(byte)((value>>16)&0xff),(byte)((value>>8)&0xff),(byte)(value&0xff)};
    }

    public static int byteArrayToInt(byte[] data){
        return   data[3] & 0xFF |
                (data[2] & 0xFF) << 8 |
                (data[1] & 0xFF) << 16 |
                (data[0] & 0xFF) << 24;
    }

    public static byte[] combineByteArray(List<byte[]> byteArrayList){

        int totalLength = 0;
        for(byte[] list: byteArrayList){
            totalLength += list.length;
        }

        byte[] result = new byte[totalLength];

        int cursor = 0;
        for(byte[] list: byteArrayList){
            if(list == null)
                return null;
            System.arraycopy(list,0,result,cursor,list.length);
            cursor += list.length;

        }

        return result;
    }
}
