package com.hq.student.stuManager.controll;

import com.hq.student.stuManager.domain.hibernate.WebSiteInfo;
import com.hq.student.stuManager.service.WebSiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hu.qiao on 2018/2/24.
 */
@Controller
@RequestMapping(value = "/webSiteInfos")
public class WebSiteInfoControll {

    @Autowired
    private WebSiteInfoService webSiteInfoService;
    /**
     *  获取用户列表
     *    处理 "/users" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getWebSiteInfoList(ModelMap map) {
        map.addAttribute("webSiteList", webSiteInfoService.findAll());
        return "webSiteList";
    }

    /**
     * 显示创建用户表单
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createWebSiteInforForm(ModelMap map) {
        map.addAttribute("webSiteInfo", new WebSiteInfo());
        map.addAttribute("action", "create");
        return "webSiteForm";
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postWebSiteInfo(@ModelAttribute WebSiteInfo webSiteInfo) {
        webSiteInfoService.insertByUser(webSiteInfo);
        return "redirect:/webSiteInfos/";
    }

    /**
     * 显示需要更新用户表单
     *    处理 "/users/{id}" 的 GET 请求，通过 URL 中的 id 值获取 User 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("webSiteInfo", webSiteInfoService.findById(id));
        map.addAttribute("action", "update");
        return "webSiteForm";
    }

    /**
     * 处理 "/users/{id}" 的 PUT 请求，用来更新 User 信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(@ModelAttribute WebSiteInfo webSiteInfo) {
        webSiteInfoService.update(webSiteInfo);
        return "redirect:/webSiteInfos/";
    }

    /**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        webSiteInfoService.delete(id);
        return "redirect:/webSiteInfos/";
    }

}
