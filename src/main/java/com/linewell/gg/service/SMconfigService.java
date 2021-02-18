package com.linewell.gg.service;

import com.alibaba.fastjson.JSONObject;
import com.linewell.gg.dao.mapperwas.module.*;

import java.util.List;

public interface SMconfigService {

    int addModuleService(ModuleService moduleService);

    JSONObject getModuleServiceByModuleUnid(String module_unid);

    int deleteModuleServiceByModuleUnid(String module_unid);

    List<ApasUniteModule> getAllApasUniteModuleWhere(String moduleName,int pageNo,int pageSize);

    int getApasUniteModuleTotal();

    ApasUniteModule getApasUniteModuleByUnid(String moduleUnid);

    int addApasUniteModule(ApasUniteModule apasUniteModule);

    int updateApasUniteModule(ApasUniteModule apasUniteModule);

    int deleteApasUniteModule(String unid);

    List<ApasService> getApasServiceByNameOrCode(String param);

    List<ModuleService> getApasServiceByModuleUnid(String moduleUnid);

    List<ApasMaterial> getApasMaterialByServiceId(String serviceId,List<ModuleMaterial> moduleMaterials);

    List<ApasMaterial> getApasMaterialByServiceIdUnin(String serviceId,List<ModuleMaterial> moduleMaterials);

    List<ModuleMaterial> getModuleMaterialByModuleUnid(String moduleUnid);

    List<ApasMaterial> getApasMaterialByUnids(String[] unids);

    ApasMaterial getApasMaterialByUnid(String unid);

    int addModuleMaterial(ModuleMaterial moduleMaterial);

    int deleteModuleMaterial(String unid);

    int addModuleSituation(ModuleSituation moduleSituation);

    int updateModuleSituation(ModuleSituation moduleSituation);

    List<ModuleSituation> getAllModuleSituationByModuleUnid(String moduleUnid);

    int deleteModuleSituation(String unid);
}
