package com.simple4h.quickstart.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple4h.quickstart.domain.Member;

/**
 * member mapper
 *
 * @author Simple4H
 */
public interface MemberMapper extends BaseMapper<Member> {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}