package com.hq.student.stuManager.domain.mapper;

import com.hq.student.stuManager.domain.StuBaseInfo;

import java.util.List;

public interface StuBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuBaseInfo record);

    int insertSelective(StuBaseInfo record);

    StuBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuBaseInfo record);

    int updateByPrimaryKey(StuBaseInfo record);

    List<StuBaseInfo> selectAllData();
    
}