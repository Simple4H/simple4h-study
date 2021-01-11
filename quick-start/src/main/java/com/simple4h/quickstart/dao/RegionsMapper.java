package com.simple4h.quickstart.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.quickstart.domain.Regions;

/**
 * TODO:
 *
 * @author Simple4H
 */
public interface RegionsMapper extends BaseMapper<Regions> {
    int deleteByPrimaryKey(Integer id);

    int insert(Regions record);

    int insertSelective(Regions record);

    Regions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Regions record);

    int updateByPrimaryKey(Regions record);
}