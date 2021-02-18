package com.linewell.gg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.linewell.gg.dao.mapperwas.module.*;
import com.linewell.gg.service.ApplyService;
import com.linewell.gg.service.SMconfigService;
import com.linewell.gg.util.DateUtil;
import com.linewell.gg.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ApplyController {

    @Autowired
    private SMconfigService sMconfigService;

    @Autowired
    private ApplyService applyService;

    /**
     * 江苏政务网公共头部页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/top")
    public String top(Model model, HttpServletRequest request) {

        return "apply/top";
    }

    /**
     * 情景选择
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/qjxz")
    public String qjxz(Model model, HttpSession session, String moduleUnid) {
        //一件事模型
        ApasUniteModule apasUniteModule = sMconfigService.getApasUniteModuleByUnid(moduleUnid);
        session.setAttribute("apasUniteModule", apasUniteModule);

        //情景配置
        List<ModuleSituation> moduleSituations = sMconfigService.getAllModuleSituationByModuleUnid(moduleUnid);
        model.addAttribute("moduleSituations", moduleSituations);

        return "apply/qjxz";
    }

    @RequestMapping(value = "/guide")
    public String guide(Model model, String guideFlow) {
        model.addAttribute("guideFlow", guideFlow);
        return "apply/guide";
    }

    /**
     * 申报清单
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/sbqd")
    public String sbqd(Model model, HttpServletRequest request) {
        String data = request.getParameter("data");
        JSONObject obj = JSON.parseObject(data);
        JSONArray arr_situation = (JSONArray) obj.get("arr_situation");
        String arr_services = String.valueOf(obj.get("arr_services"));
        String arr_materials = String.valueOf(obj.get("arr_materials"));

        List<ApasService> apasServices = applyService.getApasServiceByInfoprojids(arr_services.split(","));

        List<ApasMaterial> apasMaterials = applyService.getApasMaterialByUnids(arr_materials.split(","));

        //生成一件事实例
        String moduleInstanceUnid = UuidUtil.getUuid();
        ModuleInstance moduleInstance = new ModuleInstance();
        moduleInstance.setUnid(moduleInstanceUnid);
        moduleInstance.setCreate_time(DateUtil.formatDateTime(new Date()));
        moduleInstance.setServiceids(arr_services);
        moduleInstance.setMaterialids(arr_materials);
        applyService.addModuleInstance(moduleInstance);

        model.addAttribute("arr_situation", arr_situation);//情景选择
        model.addAttribute("apasServices", apasServices);//事项
        model.addAttribute("apasMaterials", apasMaterials);//材料
        model.addAttribute("moduleInstanceUnid", moduleInstanceUnid);//一件事实例化主键


        return "apply/sbqd";
    }

    /**
     * 一表填写
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/ybtx")
    public String ybtx(Model model, HttpServletRequest request, String moduleInstanceUnid) {
        model.addAttribute("moduleInstanceUnid", moduleInstanceUnid);
        return "apply/ybtx";
    }


    @RequestMapping(value = "/add_moduleInstance")
    @ResponseBody
    @Transactional
    public String add_moduleInstance(ModuleInstance moduleInstance) {
        int r = -1;
        if (null != moduleInstance) {
            String project_name = "关于" + moduleInstance.getApply_name() + "申请" + moduleInstance.getModule_name();
            moduleInstance.setProject_name(project_name);
            r = applyService.updateModuleInstance(moduleInstance);
        }
        if (r > 0) {
            return moduleInstance.getUnid();
        }
        return "error";
    }


    /**
     * 上传材料
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/clsc")
    public String clsc(Model model, HttpServletRequest request, String moduleInstanceId) {
        //一件事实例
        ModuleInstance moduleInstance = applyService.getModuleInstanceByUnid(moduleInstanceId);

        String arr_services = moduleInstance.getServiceids();
        String arr_materials = moduleInstance.getMaterialids();

        //事项
        List<ApasService> apasServices = applyService.getApasServiceByInfoprojids(arr_services.split(","));
        //材料
        List<ApasMaterial> apasMaterials = applyService.getApasMaterialByUnids(arr_materials.split(","));

        model.addAttribute("apasMaterials", apasMaterials);
        model.addAttribute("moduleInstanceUnid", moduleInstanceId);

        return "apply/clsc";


    }

    @RequestMapping(value = "/saveAttrStartUp")
    @ResponseBody
    public String saveAttrStartUp(HttpServletRequest request) {
        Map<String, Object> paramMap = getParameterMap(request);
        try {
            applyService.saveAttrStartUp(paramMap);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    /**
     * 获取request中的参数集合转Map
     * Map<String,String> parameterMap = RequestUtil.getParameterMap(request)
     *
     * @param request
     * @return
     */
    public Map<String, Object> getParameterMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
            if (paramValues.length > 1) {
                map.put(paramName, paramValues);
            }
        }
        return map;
    }

    /**
     * 申报告知
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/sbgz")
    public String sbgz(Model model, HttpServletRequest request, String moduleInstanceId) {

        ModuleInstance moduleInstance = applyService.getModuleInstanceByUnid(moduleInstanceId);
        ApasUniteModule apasUniteModule = sMconfigService.getApasUniteModuleByUnid(moduleInstance.getModule_unid());
        List<ApasService> apasServices = applyService.getApasServiceByInfoprojids(moduleInstance.getServiceids().split(","));
        String depts = "";
        for (ApasService apasService : apasServices) {
            depts += apasService.getDeptName() + ",";
        }
        depts = depts.substring(0, depts.length() - 1);
        model.addAttribute("moduleInstance", moduleInstance);
        model.addAttribute("apasUniteModule", apasUniteModule);
        model.addAttribute("depts", depts);//联办部门
        return "apply/sbgz";
    }

}
