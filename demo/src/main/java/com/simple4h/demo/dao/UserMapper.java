package com.simple4h.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.demo.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * TODO:
 *
 * @author Simple4H
 */
public interface UserMapper extends BaseMapper<User> {
    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);
}