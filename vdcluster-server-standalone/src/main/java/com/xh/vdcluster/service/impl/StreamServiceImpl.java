package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.repository.mapper.*;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.repository.model.User;
import com.xh.vdcluster.repository.model.VdServant;
import com.xh.vdcluster.service.StreamService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/8/1.
 */
@Component
public class StreamServiceImpl implements StreamService {
    @Resource
    StreamMapper streamMapper;

    @Resource
    ServantMapper servantMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public Stream createStream() {
        return null;
    }

    @Override
    public List<Stream> listStreams() {
        return null;
    }

    @Override
    public Stream getStream() {
        return null;
    }

    @Override
    public Stream unregisterStream() {
        return null;
    }

    @Override
    public boolean registerStream(Stream streamModel) {
        return false;
    }

    @Override
    public List<Stream> listStreamsByUserId(String userId) {

        List<Stream> streams = servantMapper.listByUserId(userId);

        return streams;
    }
}
