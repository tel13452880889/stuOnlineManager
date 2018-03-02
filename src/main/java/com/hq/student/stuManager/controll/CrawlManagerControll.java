package com.hq.student.stuManager.controll;

/**
 * Created by hu.qiao on 2018/2/24.
 */
import ch.qos.logback.classic.Logger;
import com.hq.student.stuManager.domain.hibernate.WebSiteInfo;
import com.hq.student.stuManager.service.MyCrawler;
import com.hq.student.stuManager.service.WebSiteInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crawlControll")
public class CrawlManagerControll {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MyCrawler myCrawler;

    @Autowired
    private WebSiteInfoService webSiteInfoService;

    @RequestMapping(value="/get")
    public String index() {
        /*myCrawler.crawling(new String[]{"http://www.cq.gov.cn/publicinfo/web/views/Show!index.action?orgSid=99"});*/
        return "Hello World1111";
    }

    @RequestMapping(value = "/crawlOnce/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id) {
        WebSiteInfo webSiteInfo = webSiteInfoService.findById(id);
        logger.info(" crawlOnce url: " + webSiteInfo.getUrl());
        myCrawler.crawling(new String[]{webSiteInfo.getUrl()});
        return "ok";
    }
}
