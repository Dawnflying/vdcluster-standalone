package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.Stream;

public interface StreamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stream record);

    int insertSelective(Stream record);

    Stream selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stream record);

    int updateByPrimaryKey(Stream record);
}