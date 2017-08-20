package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.Servant;
import com.xh.vdcluster.repository.model.Stream;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Servant record);

    int insertSelective(Servant record);

    Servant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Servant record);

    int updateByPrimaryKey(Servant record);

    List<Stream> listByUserId(@Param("userId")String userId);

    List<Stream> listAll();

    List<Servant> listAllServant(@Param("start")Integer start, @Param("limit")Integer limit);
}