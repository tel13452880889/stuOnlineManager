package com.hq.student.stuManager.service.impl;

import ch.qos.logback.classic.Logger;
import com.github.pagehelper.PageHelper;
import com.hq.student.stuManager.domain.StuBaseInfo;
import com.hq.student.stuManager.domain.mapper.StuBaseInfoMapper;
import com.hq.student.stuManager.service.StudentInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hu.qiao on 2018/3/2.
 */
@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService{

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StuBaseInfoMapper stuBaseInfoMapper;

    @Override
    public List<StuBaseInfo> findAllUser(int pageNum, int pageSize) {
        logger.info("StudentInfoService {} findAllUser ");
        PageHelper.startPage(pageNum, pageSize);
        return stuBaseInfoMapper.selectAllData();
    }

    @Override
    public int insertByUser(StuBaseInfo user) {
        logger.info("StudentInfoService {} insertByUser ");
        return stuBaseInfoMapper.insert(user);
    }

    @Override
    public int update(StuBaseInfo user) {
        logger.info("StudentInfoService {} update ");
        return stuBaseInfoMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Integer id) {
        logger.info("StudentInfoService {} delete ");
        return stuBaseInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public StuBaseInfo findById(Integer id) {
        logger.info("StudentInfoService {} findById ");
        return stuBaseInfoMapper.selectByPrimaryKey(id);
    }
}
