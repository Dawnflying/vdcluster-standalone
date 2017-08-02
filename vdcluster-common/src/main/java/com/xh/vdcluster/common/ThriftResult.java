package com.xh.vdcluster.common;

/**
 * Created by bloom on 2017/7/28.
 */
public class ThriftResult {

    public static final int SUCCESS = 0;

    public static final int FAILED = 1;

    private int state;

    private Object data;

    private Class className;

    public ThriftResult(int state, Object data, Class className) {
        this.state = state;
        this.data = data;
        this.className = className;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
}
