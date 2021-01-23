package com.linewell.gg.controller;

import com.linewell.gg.dao.mapperwas.module.ApasUniteModule;
import com.linewell.gg.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    
    @Autowired
    private IndexService indexService;
    
    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        List<ApasUniteModule> apasUniteModuleList = indexService.getAllApasUniteModule();



        model.addAttribute("apasUniteModuleList",apasUniteModuleList);
        return "index";
    }
}
