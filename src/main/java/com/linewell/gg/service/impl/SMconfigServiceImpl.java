package com.linewell.gg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.linewell.gg.dao.mapperwas.*;
import com.linewell.gg.dao.mapperwas.module.*;
import com.linewell.gg.service.SMconfigService;
import com.linewell.gg.util.FieldUtil;
import com.linewell.gg.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

@Service("sMconfigService")
public class SMconfigServiceImpl implements SMconfigService {

    @Autowired
    private ModuleServiceMapper moduleServiceMapper;

    @Autowired
    private ApasUniteModuleMapper apasUniteModuleMapper;

    @Autowired
    private ApasServiceMapper apasServiceMapper;

    @Autowired
    private ApasMaterialMapper apasMaterialMapper;

    @Autowired
    private ModuleMaterialMapper moduleMaterialMapper;


    @Override
    public int addModuleService(ModuleService moduleService) {
        return moduleServiceMapper.add(moduleService);
    }

    @Override
    public JSONObject getModuleServiceByModuleUnid(String module_unid) {
        ApasUniteModule apasUniteModule = apasUniteModuleMapper.getApasUniteModule(module_unid);
        List<ModuleService> li = moduleServiceMapper.getModuleServiceByModuleUnid(module_unid);
        JSONObject obj = new JSONObject();
        JSONObject obj_node = new JSONObject();
        JSONObject obj_line = new JSONObject();
        JSONObject _obj_node = null;
        JSONObject _obj_line = null;
        for (int i = 0; i < li.size(); i++) {

            //节点数据
            _obj_node = new JSONObject();
            ModuleService moduleService = li.get(i);
            /*Field[] fields=moduleService.getClass().getDeclaredFields();
            for(Field f : fields){
                _obj_node.put(f.getName(), FieldUtil.getFieldValueByName(f.getName(),moduleService));
            }*/
            _obj_node.put("name", moduleService.getService_name());
            _obj_node.put("left", moduleService.getLeft2());
            _obj_node.put("top", moduleService.getTop());
            _obj_node.put("type", moduleService.getType());
            _obj_node.put("width", moduleService.getWidth());
            _obj_node.put("height", moduleService.getHeight());
            _obj_node.put("alt", moduleService.getAlt());
            _obj_node.put("serviceid", moduleService.getServiceid());
            obj_node.put(String.valueOf(moduleService.getId()), _obj_node);

            //连接线数据
            if (StringUtils.isNotBlank(moduleService.getPre_serviceid())) {
                _obj_line = new JSONObject();
                _obj_line.put("type", "sl");
                _obj_line.put("from", moduleService.getPre_id());
                _obj_line.put("to", moduleService.getId());
                _obj_line.put("name", "");
                _obj_line.put("alt", true);
                obj_line.put(UuidUtil.getUuid(), _obj_line);
            }
        }
        obj.put("title", apasUniteModule.getModuleName() + "事项流程配置");
        obj.put("nodes", obj_node);
        obj.put("lines", obj_line);
        return obj;
    }

    @Override
    public int deleteModuleServiceByModuleUnid(String module_unid) {
        return moduleServiceMapper.deleteByModuleUnid(module_unid);
    }

    @Override
    public List<ApasUniteModule> getAllApasUniteModuleWhere(String moduleName, int pageNo, int pageSize) {
        if (StringUtils.isBlank(moduleName)) {
            moduleName = null;
        }
        return apasUniteModuleMapper.getAllApasUniteModuleWhere(moduleName, pageNo, pageSize);
    }

    @Override
    public int getApasUniteModuleTotal() {
        return apasUniteModuleMapper.getApasUniteModuleTotal();
    }

    @Override
    public ApasUniteModule getApasUniteModuleByUnid(String moduleUnid) {
        return apasUniteModuleMapper.getApasUniteModuleByUnid(moduleUnid);
    }

    @Override
    public int addApasUniteModule(ApasUniteModule apasUniteModule) {
        return apasUniteModuleMapper.addApasUniteModule(apasUniteModule);
    }

    @Override
    public int updateApasUniteModule(ApasUniteModule apasUniteModule) {
        return apasUniteModuleMapper.updateApasUniteModule(apasUniteModule);
    }

    @Override
    public int deleteApasUniteModule(String unid) {
        return apasUniteModuleMapper.deleteApasUniteModule(unid);
    }

    @Override
    public List<ApasService> getApasServiceByNameOrCode(String param) {
        if (StringUtils.isBlank(param)) {
            param = null;
        }
        return apasServiceMapper.getApasServiceByNameOrCode(param);
    }

    @Override
    public List<ModuleService> getApasServiceByModuleUnid(String moduleUnid) {
        return moduleServiceMapper.getModuleServiceByModuleUnid(moduleUnid);
    }

    @Override
    public List<ApasMaterial> getApasMaterialByServiceId(String serviceId, List<ModuleMaterial> moduleMaterials) {
        List<ApasMaterial> apasMaterials = apasMaterialMapper.getApasMaterialByServiceId(serviceId);

        //标记统一后的材料
        for (ApasMaterial apasMaterial : apasMaterials) {
            for (ModuleMaterial moduleMaterial : moduleMaterials) {
                if (moduleMaterial.getMaterialids().contains(apasMaterial.getUnid())) {
                    apasMaterial.setMaterial_rid(moduleMaterial.getMaterial_rid());
                }
            }
        }

        return apasMaterials;
    }

    @Override
    public List<ModuleMaterial> getModuleMaterialByModuleUnid(String moduleUnid) {
        return moduleMaterialMapper.getModuleMaterialByModuleUnid(moduleUnid);
    }

    @Override
    public List<ApasMaterial> getApasMaterialByUnids(String[] unids) {
        return apasMaterialMapper.getApasMaterialByUnids(unids);
    }

    @Override
    public ApasMaterial getApasMaterialByUnid(String unid) {
        return apasMaterialMapper.getApasMaterialByUnid(unid);
    }
}
