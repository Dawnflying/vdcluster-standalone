package com.xh.vdcluster.common;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdResultErrorCode {

    /**
     * 1000 - 1099 success code
     */
    public static final int SUCCESS_START = 1000;
    public static final int REGISTER_SUCCESS = 1003;
    public static final int AUTH_SUCCESS = 1001;
    public static final int SERVANT_SUCCESS = 1002;
    public static final int TOKEN_SUCCESS = 1003;


    /**
     * 1100 - 1199 error code
     */
    public static final int FAIL_START = 1100;
    public static final int AUTH_NONE = 1101;
    public static final int AUTH_FAILED = 1102;
    public static final int TOKEN_EXPIRED = 1103;
    public static final int TOKEN_ERROR = 1105;
    public static final int SERVER_ERROR = 1106;
    public static final int SERVANT_OVERLOAD = 1107;
    public static final int STREAM_ERROR = 1108;
    public static final int REGISTER_FAILED = 1009;


    public static boolean ISFAILED(int value){
        if(value >= VdResultErrorCode.FAIL_START)
            return true;
        return false;
    }
}
