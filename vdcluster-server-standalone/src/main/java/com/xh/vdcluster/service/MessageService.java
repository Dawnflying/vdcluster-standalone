package com.xh.vdcluster.service;

import java.util.concurrent.Callable;

/**
 * Created by bloom on 2017/7/20.
 */
public interface MessageService {

    void pushMessage(String topic, Object msg) throws Exception;

    void subscribe(String topic, final Callable<Object> callable) throws Exception;
}
