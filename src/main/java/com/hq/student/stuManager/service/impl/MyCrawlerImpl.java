package com.hq.student.stuManager.service.impl;

import ch.qos.logback.classic.Logger;
import com.hq.student.stuManager.common.link.LinkFilter;
import com.hq.student.stuManager.common.link.Links;
import com.hq.student.stuManager.common.page.Page;
import com.hq.student.stuManager.common.page.PageParserTool;
import com.hq.student.stuManager.common.page.RequestAndResponseTool;
import com.hq.student.stuManager.common.util.FileTool;
import com.hq.student.stuManager.service.MyCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by hu.qiao on 2018/2/24.
 */

@Service("myCrawler")
public class MyCrawlerImpl implements MyCrawler {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Override
    public void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }
    @Override
    public void crawling(String[] seeds) {
        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.baidu.com"))
                    return true;
                else
                    return false;
            }
        };
        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {
            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }
            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            //对page进行处理： 访问DOM的某个标签
            Elements es = PageParserTool.select(page,"a");
            if(!es.isEmpty()){
                /*System.out.println("下面将打印所有a标签： ");*/
                /*System.out.println(es);*/
                Document doc = Jsoup.parse(es.toString());
                /*System.out.println(doc.toString());*/
            }
            //将保存文件
            FileTool.saveToLocal(page);
            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);
            //得到超链接
            Set<String> links = PageParserTool.getLinks(page,"img");
            for (String link : links) {
                Links.addUnvisitedUrlQueue(link);
                logger.info("新增爬取路径: " + link);
            }
        }
    }
}
