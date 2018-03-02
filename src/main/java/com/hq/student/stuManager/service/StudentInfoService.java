package com.hq.student.stuManager.service;

import com.hq.student.stuManager.domain.StuBaseInfo;

import java.util.List;

/**
 * Created by hu.qiao on 2018/3/2.
 */
public interface StudentInfoService {

    List<StuBaseInfo> findAllUser(int pageNum, int pageSize);

    int insertByUser(StuBaseInfo user);

    int update(StuBaseInfo user);

    int delete(Integer id);

    StuBaseInfo findById(Integer id);

}
