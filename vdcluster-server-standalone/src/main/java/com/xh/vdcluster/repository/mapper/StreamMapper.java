package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.Stream;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StreamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stream record);

    int insertSelective(Stream record);

    Stream selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stream record);

    int updateByPrimaryKey(Stream record);

    int countByUri(@Param("uri")String uri);

    Stream selectByUri(@Param("uri")String uri);

}