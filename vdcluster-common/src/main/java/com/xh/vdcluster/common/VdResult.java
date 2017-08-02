package com.xh.vdcluster.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by bloom on 2017/7/16.
 */
@XmlRootElement(name="vdresult")
@XmlAccessorType(XmlAccessType.NONE)
public class VdResult{

    @XmlElement(name = "msg")
    private String msg;

    @XmlElement(name = "code")
    private int code;

    @XmlElement(name = "data")
    private Object data;

    @XmlElement(name = "requestId")
    private String requestId;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public VdResult(String msg, int code, Object data, String requestId) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.requestId = requestId;
    }

    public VdResult(){}
}
