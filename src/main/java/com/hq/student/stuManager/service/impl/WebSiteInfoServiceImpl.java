package com.hq.student.stuManager.service.impl;

import ch.qos.logback.classic.Logger;
import com.hq.student.stuManager.domain.hibernate.WebSiteInfo;
import com.hq.student.stuManager.domain.hibernate.WebSiteInfoRepository;
import com.hq.student.stuManager.service.WebSiteInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hu.qiao on 2018/2/24.
 */
@Service("webSiteInfoService")
public class WebSiteInfoServiceImpl implements WebSiteInfoService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebSiteInfoRepository webSiteInfoRepository;

    @Override
    public List<WebSiteInfo> findAll() {
        logger.info("WebSiteInfoService{} findAll ");
        return webSiteInfoRepository.findAll();
    }

    @Override
    public WebSiteInfo insertByUser(WebSiteInfo user) {
        logger.info("WebSiteInfoService{} insertByUser param : " + user.toString());
        user.setStatus(0);
        return webSiteInfoRepository.save(user);
    }

    @Override
    public WebSiteInfo update(WebSiteInfo user) {
        logger.info("WebSiteInfoService{} update param : " + user.toString());
        return webSiteInfoRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        logger.info("WebSiteInfoService{} delete id :" + id);
        webSiteInfoRepository.delete(id);
    }

    @Override
    public WebSiteInfo findById(Long id) {
        logger.info("WebSiteInfoService{} findById id :" + id);
        return webSiteInfoRepository.findOne(id);
    }
}
