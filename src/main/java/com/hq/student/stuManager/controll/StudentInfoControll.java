package com.hq.student.stuManager.controll;

import ch.qos.logback.classic.Logger;
import com.hq.student.stuManager.domain.StuBaseInfo;
import com.hq.student.stuManager.domain.mapper.MajorInfoMapper;
import com.hq.student.stuManager.service.StudentInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by hu.qiao on 2018/2/24.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentInfoControll {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private MajorInfoMapper majorInfoMapper;


    /**
     *  获取用户列表
     *    处理 "/users" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
/*    @RequestMapping(method = RequestMethod.GET)
    public String getWebSiteInfoList(ModelMap map) {
        map.addAttribute("webSiteList", webSiteInfoService.findAll());
        return "webSiteList";
    }*/

/*    */
    /**
     * 显示创建用户表单
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createWebSiteInforForm(ModelMap map) {
        map.addAttribute("studentInfo", new StuBaseInfo());
        map.addAttribute("action", "create");
        map.addAttribute("majorList",  majorInfoMapper.selectAllData());
        map.addAttribute("title","新增学员信息");
        return "/studentInfo";
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postWebSiteInfo(@ModelAttribute StuBaseInfo stuBaseInfo) {
        Long timeStamp = System.currentTimeMillis();
        stuBaseInfo.setStuid("STU" + timeStamp);
        logger.info(timeStamp.toString());
        stuBaseInfo.setReporttime(Integer.parseInt(TimeUnit.MILLISECONDS.toSeconds(timeStamp)+""));
        logger.info("stuBaseInfo {} " + stuBaseInfo.toString());
        int re = studentInfoService.insertByUser(stuBaseInfo);
        if(re>0){
            return "redirect:/schoolManagement";
        }else{
            return "error";
        }
    }

    /**
     * 显示需要更新用户表单
     *    处理 "/users/{id}" 的 GET 请求，通过 URL 中的 id 值获取 User 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Integer id, ModelMap map) {
        map.addAttribute("studentInfo", studentInfoService.findById(id));
        map.addAttribute("action", "update");
        map.addAttribute("majorList",  majorInfoMapper.selectAllData());
        map.addAttribute("title","修改学员信息");
        return "/studentInfo";
    }

    /**
     * 处理 "/users/{id}" 的 PUT 请求，用来更新 User 信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(@ModelAttribute StuBaseInfo stuBaseInfo) {
        studentInfoService.update(stuBaseInfo);
        return "redirect:/schoolManagement/";
    }

    /**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
   /* @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        webSiteInfoService.delete(id);
        return "redirect:/webSiteInfos/";
    }*/

}
