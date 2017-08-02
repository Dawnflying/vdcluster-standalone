package com.xh.vdcluster.service;

import com.xh.vdcluster.repository.model.Stream;

import java.util.List;

/**
 * Created by bloom on 2017/7/16.
 */
public interface StreamService {

    Stream createStream();

    List<Stream> listStreams();

    Stream getStream();

    Stream unregisterStream();

    boolean registerStream(Stream streamModel);
}
