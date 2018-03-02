package com.hq.student.stuManager.controll;

import ch.qos.logback.classic.Logger;
import com.hq.student.stuManager.domain.mapper.MajorInfoMapper;
import com.hq.student.stuManager.service.StudentInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hu.qiao on 2018/3/2.
 */
@Controller
public class SystemIndexControll {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private MajorInfoMapper majorInfoMapper;

    @RequestMapping("/")
    public String index(){
        return "/index";
    }

    @RequestMapping("/schoolManagement")
    public String schoolManagement(ModelMap map){
        map.addAttribute("stuList",  studentInfoService.findAllUser(1,10));
        return "/schoolManagementList";
    }

    @RequestMapping("/studentInfo")
    public String studentInfo(ModelMap map){
        map.addAttribute("majorList",  majorInfoMapper.selectAllData());
        map.addAttribute("title","新增学员信息");
        return "/studentInfo";
    }


}
