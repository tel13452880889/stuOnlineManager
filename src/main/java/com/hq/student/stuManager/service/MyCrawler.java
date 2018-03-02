package com.hq.student.stuManager.service;

/**
 * Created by hu.qiao on 2018/2/24.
 */
public interface MyCrawler {

    void initCrawlerWithSeeds(String[] seeds);

    void crawling(String[] seeds);

}
