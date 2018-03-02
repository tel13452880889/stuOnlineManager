package com.hq.student.stuManager.service;

import com.hq.student.stuManager.domain.hibernate.WebSiteInfo;

import java.util.List;

/**
 * Created by hu.qiao on 2018/2/24.
 */
public interface WebSiteInfoService {

    List<WebSiteInfo> findAll();

    WebSiteInfo insertByUser(WebSiteInfo user);

    WebSiteInfo update(WebSiteInfo user);

    void delete(Long id);

    WebSiteInfo findById(Long id);
}
