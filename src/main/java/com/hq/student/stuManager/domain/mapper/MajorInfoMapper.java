package com.hq.student.stuManager.domain.mapper;

import com.hq.student.stuManager.domain.MajorInfo;

import java.util.List;

public interface MajorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorInfo record);

    int insertSelective(MajorInfo record);

    MajorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorInfo record);

    int updateByPrimaryKey(MajorInfo record);

    List<MajorInfo> selectAllData();
}