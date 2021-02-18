package com.linewell.gg.controller;

import com.linewell.gg.dao.mapperwas.module.ApasUniteModule;
import com.linewell.gg.dao.mapperwas.module.JsUser;
import com.linewell.gg.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    
    @Autowired
    private IndexService indexService;
    
    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request, HttpSession session){
        //江苏政务服务网用户
        JsUser user = new JsUser();
        user.setCorusercardId("U123456789");
        user.setCoruserName("张三法");
        user.setUserType("0");
        user.setMobile("18451461851");
        user.setName("张三");
        user.setIdcardNum("321321199004175639");
        session.setAttribute("user", user);


        List<ApasUniteModule> apasUniteModuleList = indexService.getAllApasUniteModule();
        model.addAttribute("apasUniteModuleList",apasUniteModuleList);
        return "index";
    }
}
