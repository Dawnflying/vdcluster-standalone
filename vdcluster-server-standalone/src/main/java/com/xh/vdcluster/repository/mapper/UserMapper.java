package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUsername(String username);

    int updateUserToken(String userId, String token);

    User getUserByUserId(String userId);
}