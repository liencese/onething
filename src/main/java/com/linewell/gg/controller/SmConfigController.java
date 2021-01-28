package com.linewell.gg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.linewell.gg.dao.mapperwas.module.*;
import com.linewell.gg.service.SMconfigService;
import com.linewell.gg.util.DateUtil;
import com.linewell.gg.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SmConfigController {

    @Autowired
    private SMconfigService sMconfigService;

    @RequestMapping(value = "/module_config")
    public String module_config(Model model, HttpServletRequest request) {

        return "smconfig/module_config";
    }

    @RequestMapping(value = "/get_module")
    @ResponseBody
    public ResponseResult get_module(HttpServletRequest request) {
        String moduleName = request.getParameter("moduleName");
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int sizeNo = Integer.parseInt(request.getParameter("sizeNo"));
        int startNo = pageNo * sizeNo - sizeNo;
        List<ApasUniteModule> li = sMconfigService.getAllApasUniteModuleWhere(moduleName, startNo, sizeNo);
        int total = sMconfigService.getApasUniteModuleTotal();
        ResponseResult rs = new ResponseResult();
        rs.setCode(0);
        rs.setCount(total);
        rs.setMsg("");
        rs.setData(li);

        return rs;

    }

    @RequestMapping("module_edit")
    public String module_edit(Model model, @RequestParam(value = "moduleUnid", required = false) String moduleUnid) {
        ApasUniteModule apasUniteModule = sMconfigService.getApasUniteModuleByUnid(moduleUnid);
        model.addAttribute("apasUniteModule", apasUniteModule);
        return "smconfig/module_edit";
    }

    @RequestMapping(value = "/save_moduleConfig")
    @ResponseBody
    @Transactional
    public int save_moduleConfig(ApasUniteModule apasUniteModule) {

        int r = -1;

        if ("on".equalsIgnoreCase(apasUniteModule.getIsPublish())) {
            apasUniteModule.setIsPublish("Y");
        } else {
            apasUniteModule.setIsPublish("N");
        }

        //更新
        if (StringUtils.isNotBlank(apasUniteModule.getUnid())) {
            apasUniteModule.setUpdateTime(DateUtil.formatDateTime(new Date()));
            r = sMconfigService.updateApasUniteModule(apasUniteModule);
        } else {//新增
            apasUniteModule.setUnid(UuidUtil.getUuid());
            apasUniteModule.setCreateTime(DateUtil.formatDateTime(new Date()));
            r = sMconfigService.addApasUniteModule(apasUniteModule);
        }
        return r;
    }

    @RequestMapping(value = "/delete_moduleConfig")
    @ResponseBody
    @Transactional
    public int delete_moduleConfig(String moduleUnid) {
        return sMconfigService.deleteApasUniteModule(moduleUnid);
    }

    @RequestMapping(value = "/service_config")
    public String service_config(Model model, HttpServletRequest request) {
        String moduleUnid = request.getParameter("moduleUnid");
        model.addAttribute("moduleUnid", moduleUnid);
        return "smconfig/service_config";
    }

    @RequestMapping(value = "/get_serviceConfig")
    @ResponseBody
    public JSONObject getModuleServiceByModuleUnid(String moduleUnid) {
        return sMconfigService.getModuleServiceByModuleUnid(moduleUnid);
    }

    @RequestMapping(value = "/service_chose")
    public String service_chose(Model model, HttpServletRequest request) {
        return "smconfig/service_chose";
    }

    @RequestMapping(value = "/get_servicebync")
    @ResponseBody
    public ResponseResult get_servicebync(String param) {
        List<ApasService> li = sMconfigService.getApasServiceByNameOrCode(param);
        ResponseResult rs = new ResponseResult();
        rs.setCode(0);
        rs.setCount(20);
        rs.setMsg("");
        rs.setData(li);
        return rs;
    }

    @RequestMapping(value = "/save_serviceConfig")
    @ResponseBody
    @Transactional
    public int save_serviceConfig(HttpServletRequest request) {
        String nodeData = request.getParameter("nodeData");
        String moduleUnid = request.getParameter("moduleUnid");
        JSONArray arr = JSONArray.parseArray(nodeData);
        int r = -1;
        ModuleService moduleService = null;
        sMconfigService.deleteModuleServiceByModuleUnid(moduleUnid);
        for (int i = 0; i < arr.size(); i++) {
            JSONObject o = (JSONObject) arr.get(i);
            moduleService = JSON.toJavaObject(o, ModuleService.class);
            moduleService.setModule_unid(moduleUnid);
            moduleService.setUnid(UuidUtil.getUuid());
            if (StringUtils.isNotBlank(moduleService.getPre_serviceid())) {
                moduleService.setIs_start(0);
            } else {
                moduleService.setIs_start(1);
            }
            r = sMconfigService.addModuleService(moduleService);
        }
        return r;
    }

    @RequestMapping(value = "/material_config")
    public String material_config(Model model, HttpServletRequest request) {
        String moduleUnid = request.getParameter("moduleUnid");
        model.addAttribute("moduleUnid", moduleUnid);
        return "smconfig/material_config";
    }

    @RequestMapping(value = "/get_materialConfig")
    @ResponseBody
    public Map<String, Object> getModuleMaterialByModuleUnid(String moduleUnid) {
        //统一材料
        List<ModuleMaterial> moduleMaterials = sMconfigService.getModuleMaterialByModuleUnid(moduleUnid);
        for (ModuleMaterial moduleMaterial : moduleMaterials) {
            //统一后材料
            moduleMaterial.setApasMaterial_r(sMconfigService.getApasMaterialByUnid(moduleMaterial.getMaterial_rid()));
            //原材料
            String[] unids = moduleMaterial.getMaterialids().split(",");
            moduleMaterial.setApasMaterialList(sMconfigService.getApasMaterialByUnids(unids));
        }
        //模型-事项
        List<ModuleService> moduleServices = sMconfigService.getApasServiceByModuleUnid(moduleUnid);
        //原材料
        for (ModuleService moduleService : moduleServices) {
            moduleService.setApasMaterialList(sMconfigService.getApasMaterialByServiceId(moduleService.getServiceid(), moduleMaterials));

        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("moduleServices", moduleServices);
        map.put("moduleMaterials", moduleMaterials);
        return map;
    }

    @RequestMapping(value = "/save_materialConfig")
    @ResponseBody
    @Transactional
    public int save_materialConfig(ModuleMaterial moduleMaterial) {
        moduleMaterial.setUnid(UuidUtil.getUuid());
        int r = sMconfigService.addModuleMaterial(moduleMaterial);
        return r;
    }

    @RequestMapping(value = "/delete_materialConfig")
    @ResponseBody
    @Transactional
    public int delete_materialConfig(String unid) {
        int r = sMconfigService.deleteModuleMaterial(unid);
        return r;
    }
}
