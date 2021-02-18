package com.linewell.gg.service;

import com.linewell.gg.dao.mapperwas.module.ApasMaterial;
import com.linewell.gg.dao.mapperwas.module.ApasService;
import com.linewell.gg.dao.mapperwas.module.AppFile;
import com.linewell.gg.dao.mapperwas.module.ModuleInstance;

import java.util.List;
import java.util.Map;

public interface ApplyService {

    List<ApasService> getApasServiceByInfoprojids(String[] infoprojids);

    List<ApasMaterial> getApasMaterialByUnids(String[] unids);

    int addModuleInstance(ModuleInstance moduleInstance);

    int updateModuleInstance(ModuleInstance moduleInstance);

    ModuleInstance getModuleInstanceByUnid(String unid);

    int addFile(AppFile appFile);

    int delFile(String fileUnid);

    void saveAttrStartUp(Map<String, Object> paramMap);
}
