package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.VdServant;

import java.util.List;

public interface VdServantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VdServant record);

    int insertSelective(VdServant record);

    VdServant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VdServant record);

    int updateByPrimaryKey(VdServant record);

}