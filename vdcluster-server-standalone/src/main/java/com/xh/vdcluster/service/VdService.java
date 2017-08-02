package com.xh.vdcluster.service;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.VdResult;

import java.util.List;

/**
 * Created by macbookpro on 17/7/22.
 */
public interface VdService {

    VdResult addServant(String userId, List<DetectServiceConfiguration> configuration);

    VdResult stopServant(String userId, List<String> servantIds);

    VdResult removeServant(String userId, List<String> servantIds);
}
