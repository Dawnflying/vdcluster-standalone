package com.xh.vdcluster.repository.mapper;


import com.xh.vdcluster.vdmanager.beans.VdServant;

import java.util.List;

/**
 * Created by macbookpro on 17/7/23.
 */
public interface ServantMapper {

    VdServant getServantByServantId(Integer servantId);

    List<VdServant> getServantsByUserId(String userId);

    void insertServant(VdServant servant);

    void deleteServantByServantId(Integer servantId);

    void updateServant(VdServant servant);

}
