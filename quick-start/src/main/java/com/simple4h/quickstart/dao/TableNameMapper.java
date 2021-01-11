package com.simple4h.quickstart.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.quickstart.domain.TableName;

/**
 * tableName mapper
 *
 * @author Simple4H
 */
public interface TableNameMapper extends BaseMapper<TableName> {
    int insert(TableName record);

    int insertSelective(TableName record);
}