package com.simple4h.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.demo.domain.Member;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * TODO:
 *
 * @author Simple4H
 */
public interface MemberMapper extends BaseMapper<Member> {
    int updateBatch(List<Member> list);

    int updateBatchSelective(List<Member> list);

    int batchInsert(@Param("list") List<Member> list);

    int insertOrUpdate(Member record);

    int insertOrUpdateSelective(Member record);
}