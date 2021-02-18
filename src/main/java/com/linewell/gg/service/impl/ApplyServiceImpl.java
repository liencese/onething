package com.linewell.gg.service.impl;

import com.linewell.gg.dao.mapperwas.*;
import com.linewell.gg.dao.mapperwas.module.*;
import com.linewell.gg.service.ApplyService;
import com.linewell.gg.util.DateUtil;
import com.linewell.gg.util.StrUtil;
import com.linewell.gg.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    public static final String HANDLESTATE_TEMP = "草稿";
    public static final String HANDLESTATE_RECEIVE = "收件";
    public static final String HANDLESTATE_PREACCEPT = "受理";
    public static final String HANDLESTATE_REGISTER = "登记";
    public static final String HANDLESTATE_CANCEL = "撤销";

    public static final String APPLYSOURCE_YJS = "一件事申报";

    @Autowired
    private ApasServiceMapper apasServiceMapper;

    @Autowired
    private ApasMaterialMapper apasMaterialMapper;

    @Autowired
    private ModuleInstanceMapper moduleInstanceMapper;

    @Autowired
    private AppFileMapper appFileMapper;

    @Autowired
    private ModuleServiceMapper moduleServiceMapper;

    @Autowired
    private ApasInfoMapper apasInfoMapper;

    @Autowired
    private ApasAttrMapper apasAttrMapper;

    @Autowired
    private ModuleMaterialMapper moduleMaterialMapper;

    @Override
    public List<ApasService> getApasServiceByInfoprojids(String[] infoprojids) {
        return apasServiceMapper.getApasServiceByInfoprojids(infoprojids);
    }

    @Override
    public List<ApasMaterial> getApasMaterialByUnids(String[] unids) {
        return apasMaterialMapper.getApasMaterialByUnids(unids);
    }

    @Override
    public int addModuleInstance(ModuleInstance moduleInstance) {
        return moduleInstanceMapper.addModuleInstancese(moduleInstance);
    }

    @Override
    public int updateModuleInstance(ModuleInstance moduleInstance) {
        return moduleInstanceMapper.updateModuleInstancese(moduleInstance);
    }

    @Override
    public ModuleInstance getModuleInstanceByUnid(String unid) {
        return moduleInstanceMapper.getModuleInstanceByUnid(unid);
    }

    @Override
    public int addFile(AppFile appFile) {
        return appFileMapper.addFile(appFile);
    }


    @Override
    public int delFile(String fileUnid) {
        return appFileMapper.delFile(fileUnid);
    }

    /**
     * 生成办件
     *
     * @param paramMap
     */
    @Override
    public void saveAttrStartUp(Map<String, Object> paramMap) {
        String moduleInstanceUnid = paramMap.get("moduleInstanceUnid") + "";//一件事实例化unid
        ModuleInstance moduleInstance = moduleInstanceMapper.getModuleInstanceByUnid(moduleInstanceUnid);
        String serviceids = moduleInstance.getServiceids();//情景选择 事项
        if (StringUtils.isNotBlank(serviceids)) {
            //String[] arr_serviceids = serviceids.split(",");
            String moduleUnid = moduleInstance.getModule_unid();
            List<ModuleService> moduleServices = moduleServiceMapper.getModuleServiceByModuleUnid(moduleUnid);
            for (ModuleService moduleService : moduleServices) {
                //根据事项编号infoprojid获取事项
                String serviceid = moduleService.getServiceid();
                //根据情景选择的事项生成办件
                if (serviceids.contains(serviceid)) {
                    ApasService apasService = apasServiceMapper.getApasServiceByInfoprojid(serviceid);
                    ApasInfo apasInfo = new ApasInfo();

                    apasInfo.setUnid(UuidUtil.getUuid());
                    apasInfo.setModuleUnid(moduleInstanceUnid);
                    apasInfo.setApplyname(moduleInstance.getApply_name());
                    apasInfo.setPhone(moduleInstance.getApply_phone());
                    apasInfo.setMobile(moduleInstance.getApply_phone());
                    apasInfo.setIdcard(moduleInstance.getApply_idcard());
                    apasInfo.setIdcardType("身份证");
                    apasInfo.setLegalman(moduleInstance.getLegalman());
                    apasInfo.setContactman(moduleInstance.getContact_name());
                    apasInfo.setAddress(moduleInstance.getAddress());
                    apasInfo.setContactIdcard(moduleInstance.getContact_idcard());
                    apasInfo.setServicetype(apasService.getServiceType());
                    String projid = createProjId(serviceid, apasService.getDept_ql_reg_no());
                    apasInfo.setProjid(projid);
                    apasInfo.setContactIdcardType("身份证");
                    apasInfo.setReceiveDeptid(apasService.getDeptUnid());
                    apasInfo.setReceiveDeptname(apasService.getDeptName());
                    apasInfo.setCreateTime(DateUtil.formatDateTime(new Date()));

                    //开始事项
                    if (moduleService.getIs_start() == 1) {
                        apasInfo.setHandlestate(HANDLESTATE_PREACCEPT);
                    } else {
                        apasInfo.setHandlestate(HANDLESTATE_RECEIVE);
                    }
                    apasInfo.setProjectname("关于" + moduleInstance.getApply_name() + "申请" + apasService.getServiceName());
                    apasInfo.setApplyfrom(APPLYSOURCE_YJS);
                    apasInfo.setServiceid(apasService.getUnid());
                    apasInfo.setServicecode(serviceid);
                    apasInfo.setServicename(apasService.getServiceName());
                    apasInfo.setPromiseday(apasService.getPromiseDay());
                    apasInfo.setApplyType(moduleInstance.getApply_type());
                    apasInfo.setMemo(moduleInstance.getMemo());

                    //插入办件
                    int r = apasInfoMapper.addApasInfo(apasInfo);

                    List<ApasMaterial> apasMaterials = apasMaterialMapper.getApasMaterialByServiceId(serviceid);
                    for (ApasMaterial am : apasMaterials) {
                        //插入apas_attr
                        ApasAttr apasAttr = new ApasAttr();
                        apasAttr.setUnid(UuidUtil.getUuid());
                        apasAttr.setPunid(apasInfo.getUnid());
                        apasAttr.setMaterialid(am.getUnid());
                        apasAttr.setName(am.getInfoname());
                        apasAttr.setSavestate("upload");
                        apasAttr.setIschecked("1");
                        apasAttr.setCreatetime(DateUtil.formatDateTime(new Date()));
                        apasAttrMapper.addApasAttr(apasAttr);

                        //更新app_file
                        ModuleMaterial moduleMaterial = moduleMaterialMapper.getModuleMaterialByModuleUnidMid(moduleUnid, am.getUnid());
                        Object fileUnids = paramMap.get(am.getUnid() + "_upload");
                        if (null != moduleMaterial) {
                            String mid = moduleMaterial.getMaterial_rid();
                            if (mid.equals(am.getUnid())) {
                                if (isArray(fileUnids)) {
                                    String[] arr = (String[]) fileUnids;
                                    for (String file_unid : arr) {
                                        appFileMapper.updateFile(apasAttr.getUnid(), file_unid);
                                    }
                                } else {
                                    String file_unid = fileUnids + "";
                                    appFileMapper.updateFile(apasAttr.getUnid(), file_unid);
                                }
                            } else {
                                Object _fileUnids = paramMap.get(mid + "_upload");
                                if (isArray(_fileUnids)) {
                                    String[] arr = (String[]) _fileUnids;
                                    for (String file_unid : arr) {
                                        AppFile appFile = appFileMapper.getFile(file_unid);
                                        appFile.setFile_unid(UuidUtil.getUuid());
                                        appFile.setFile_belongto(apasAttr.getUnid());
                                        appFileMapper.addFile(appFile);
                                    }
                                } else {
                                    String file_unid = _fileUnids + "";
                                    AppFile appFile = appFileMapper.getFile(file_unid);
                                    appFile.setFile_unid(UuidUtil.getUuid());
                                    appFile.setFile_belongto(apasAttr.getUnid());
                                    appFileMapper.addFile(appFile);
                                }
                            }
                        } else {
                            //多个材料
                            if (isArray(fileUnids)) {
                                String[] arr = (String[]) fileUnids;
                                for (String file_unid : arr) {
                                    appFileMapper.updateFile(apasAttr.getUnid(), file_unid);
                                }
                            } else {
                                String file_unid = fileUnids + "";
                                appFileMapper.updateFile(apasAttr.getUnid(), file_unid);
                            }

                        }


                    }

                }


            }


            //设置办件串并联
            for (ModuleService moduleService : moduleServices) {
                if (StringUtils.isNotBlank(moduleService.getPre_serviceid())) {
                    //前置办件
                    ApasInfo pre_apasInfo = apasInfoMapper.getApasInfoByModuleService(moduleInstanceUnid, moduleService.getPre_serviceid());
                    //后置办件
                    ApasInfo after_apasInfo = apasInfoMapper.getApasInfoByModuleService(moduleInstanceUnid, moduleService.getServiceid());
                    //为前置办件设置后置办件unid 用逗号分隔
                    if (StringUtils.isNotBlank(pre_apasInfo.getNextUnid())) {
                        pre_apasInfo.setNextUnid(pre_apasInfo.getNextUnid() + "," + after_apasInfo.getUnid());
                    } else {
                        pre_apasInfo.setNextUnid(after_apasInfo.getUnid());
                    }
                    apasInfoMapper.updateApasInfo(pre_apasInfo);
                }
            }

        }


    }

    /**
     * 生成办件编号 projid
     *
     * @param servicecode
     * @param DEPT_QL_REG_NO
     * @return
     */
    public String createProjId(String servicecode, String DEPT_QL_REG_NO) {
        if (StringUtils.isEmpty(DEPT_QL_REG_NO)) {
            DEPT_QL_REG_NO = servicecode;
        }
        String datetime = DateUtil.format("yyyyMMdd", new Date());
        String projid = DEPT_QL_REG_NO + datetime + getTodaySeqNumFromTable(DEPT_QL_REG_NO, datetime);
        return projid;
    }

    private synchronized String getTodaySeqNumFromTable(String servicecode, String datetime) {
        int projidindex = apasInfoMapper.getProjidindex(servicecode, datetime);
        return StrUtil.fillZero(String.valueOf(projidindex), 4, 1);
    }

    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }

        return obj.getClass().isArray();
    }
}
