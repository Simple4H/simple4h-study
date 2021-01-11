package com.simple4h.quickstart.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.quickstart.domain.User;

/**
 * TODO:
 *
 * @author Simple4H
 */
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}