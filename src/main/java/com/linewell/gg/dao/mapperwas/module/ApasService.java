package com.linewell.gg.dao.mapperwas.module;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * 权力事项表(APAS_SERVICE)
 */
public class ApasService implements Serializable {

	/** 版本号 */
	private static final long serialVersionUID = -3019982980250357749L;

	/** 主键 */
	private String unid;

	/** 事项名称 */
	private String serviceName;

	/** 事项类型（许可、征收、强制、公共服务等） */
	private String serviceType;

	/** 事项子类型 */
	private String serviceSubType;

	/** 事项编号 */
	private String serviceCode;

	private String infoProjid;

	/** 大项编号 */
	private String serviceMainCode;

	/** 子项编号 */
	private String serviceSubCode;

	/** 服务内容 */
	private String serviceContent;

	/** 实施编码 */
	private String implementCode;

	/** 实施主体性质（法定机关、授权组织、受委托组织） */
	private String implementPropety;

	/** 所属部门UNID */
	private String deptUnid;

	/** 所属部门名称 */
	private String deptName;

	/** 所属部门编码 */
	private String deptCode;

	/** 所属区域编码 */
	private String areaCode;

	/** 办件类型（即办件、承诺件） */
	private String infoType;

	/** 法定期限 */
	private Integer legalDays = 0;

	/** 法定期限 单位（工作日、自然日、周、月等）*/
	private String legalDaysUnit;

	/** 法定期限说明 */
	private String legalDaysDesc;

	/** 法律依据或许可标准 */
	private String legalStandard;

	/** 承诺时限 */
	private Integer promiseDays = 0;

	/** 承诺期限 单位（工作日、自然日、周、月等）*/
	private String promiseDaysUnit;

	/** 承诺时限说明 */
	private String promiseDaysDesc;

	/** 申请方式 */
	private String applyType ;

	/** 申请条件说明 */
	private String applyConditionDesc;

	/** 受理地址说明(包括地址、邮编、楼层及窗口号) */
	private String acceptAddrDesc;

	/** 受理时间说明 */
	private String acceptTimeDesc;

	/** 办理流程说明 */
	private String flowDesc;

	/** 面向用户对象 */
	private String forUser;

	/** 面向个人的主题分类 */
	private String personZt;

	/** 面向个人的事项分类(人生事件) */
	private String personRssj;

	/** 面向个人的特定人群分类 */
	private String personTdrq;

	/** 面向法人的主题分类 */
	private String enterpriseZt;

	/** 面向法人的特定对象分类 */
	private String enterpriseTddx;

	/** 面向法人的经营活动分类 */
	private String enterpriseJyhd;

	/** 办理结果获取方式 */
	private String resultGetType;

	/** 办理结果送达时限 */
	private String resultSendTime;

	/** 办理结果类型（批文、证照） */
	private String resultType;

	/** 办结结果名称（批文或证照名称） */
	private String resultName;

	/** 办结结果说明 */
	private String resultDesc;

	/** 数量限制描述 */
	private String countLimitDesc;

	/** 星级 */
	private Integer starLevel;

	/** 涉及的中介服务 */
	private String mediationServices;

	/** 权限划分（划分同一事项在不同层级间行使的标准） */
	private String permissionsDivision;

	/** 行使内容 */
	private String performContent;

	/** 行使层级（国家级、省级、市级） */
	private String performLevel;

	/** 运行系统（国家级、省级、市级） */
	private String runSystem;

	/** 通办范围（全国、跨省、跨市、跨县） */
	private String handleScope;

	/** 权力来源 */
	private String powerSource;

	/** 权力特性（国家级、省级、市级、县级、乡级、村级） */
	private String powerFeatures;

	/** 实施或牵头的处（科）室名称、责任部门、实施机关的内设或下属单位 */
	private String leadDepts;

	/** 窗口描述 */
	private String winDesc;

	/** 窗口备注信息 */
	private String winMemo;

	/** 地图坐标 */
	private String mapPosition;

	/** 交通指引 */
	private String trafficGuide;

	/** 主办处室 */
	private String firstOffice;

	/** 会办处室 */
	private String secondOffice;

	/** 办公时间 */
	private String officeTime;

	/** 联系人 */
	private String contactMan;

	/** 联系电话 */
	private String contactPhone;

	/** 咨询方式 */
	private String askMode;

	/** 咨询电话 */
	private String askPhone;

	/** 监督（投诉）方式 */
	private String monitorMode;

	/** 监督（投诉）电话 */
	private String monitorPhone;

	/** 显示情况类型  */
	private String showType;

	/** 事项来源类型：0合并、1拆分 */
	private String sourceType;

	/** 来源事项 */
	private String sourceService;

	/** 排序号 */
	private Integer sortid = 0;

	/** 状态(Y启用 N.禁用 D.已删除) */
	private String status;

	/** 计划生效日期 */
	private String effectiveDate;

	/** 计划取消日期 */
	private String cancelDate;

	/** 创建时间 */
	private String createTime;

	/** 所属系统id（租户id） */
	private String appUnid;

	/** 事项扩展信息 */
	private JSONObject extInfo;

	/** 是否收费 */
	private String isCharge ;

	/** 收费方式 */
	private String chargeType ;

	/** 收费方式说明 */
	private String chargeDesc ;

	/** 收费标准 */
	private String chargeStandard ;

	/** 申报材料 */
	private List<ApasMaterial> materialList;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getInfoProjid() {
		return infoProjid;
	}

	public void setInfoProjid(String infoProjid) {
		this.infoProjid = infoProjid;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceSubType() {
		return serviceSubType;
	}

	public void setServiceSubType(String serviceSubType) {
		this.serviceSubType = serviceSubType;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceMainCode() {
		return serviceMainCode;
	}

	public void setServiceMainCode(String serviceMainCode) {
		this.serviceMainCode = serviceMainCode;
	}

	public String getServiceSubCode() {
		return serviceSubCode;
	}

	public void setServiceSubCode(String serviceSubCode) {
		this.serviceSubCode = serviceSubCode;
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	public String getImplementCode() {
		return implementCode;
	}

	public void setImplementCode(String implementCode) {
		this.implementCode = implementCode;
	}

	public String getImplementPropety() {
		return implementPropety;
	}

	public void setImplementPropety(String implementPropety) {
		this.implementPropety = implementPropety;
	}

	public String getDeptUnid() {
		return deptUnid;
	}

	public void setDeptUnid(String deptUnid) {
		this.deptUnid = deptUnid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public Integer getLegalDays() {
		return legalDays;
	}

	public void setLegalDays(Integer legalDays) {
		this.legalDays = legalDays;
	}

	public String getLegalDaysUnit() {
		return legalDaysUnit;
	}

	public void setLegalDaysUnit(String legalDaysUnit) {
		this.legalDaysUnit = legalDaysUnit;
	}

	public String getLegalDaysDesc() {
		return legalDaysDesc;
	}

	public void setLegalDaysDesc(String legalDaysDesc) {
		this.legalDaysDesc = legalDaysDesc;
	}

	public String getLegalStandard() {
		return legalStandard;
	}

	public void setLegalStandard(String legalStandard) {
		this.legalStandard = legalStandard;
	}

	public Integer getPromiseDays() {
		return promiseDays;
	}

	public void setPromiseDays(Integer promiseDays) {
		this.promiseDays = promiseDays;
	}

	public String getPromiseDaysUnit() {
		return promiseDaysUnit;
	}

	public void setPromiseDaysUnit(String promiseDaysUnit) {
		this.promiseDaysUnit = promiseDaysUnit;
	}

	public String getPromiseDaysDesc() {
		return promiseDaysDesc;
	}

	public void setPromiseDaysDesc(String promiseDaysDesc) {
		this.promiseDaysDesc = promiseDaysDesc;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getApplyConditionDesc() {
		return applyConditionDesc;
	}

	public void setApplyConditionDesc(String applyConditionDesc) {
		this.applyConditionDesc = applyConditionDesc;
	}

	public String getAcceptAddrDesc() {
		return acceptAddrDesc;
	}

	public void setAcceptAddrDesc(String acceptAddrDesc) {
		this.acceptAddrDesc = acceptAddrDesc;
	}

	public String getAcceptTimeDesc() {
		return acceptTimeDesc;
	}

	public void setAcceptTimeDesc(String acceptTimeDesc) {
		this.acceptTimeDesc = acceptTimeDesc;
	}

	public String getFlowDesc() {
		return flowDesc;
	}

	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}

	public String getForUser() {
		return forUser;
	}

	public void setForUser(String forUser) {
		this.forUser = forUser;
	}

	public String getPersonZt() {
		return personZt;
	}

	public void setPersonZt(String personZt) {
		this.personZt = personZt;
	}

	public String getPersonRssj() {
		return personRssj;
	}

	public void setPersonRssj(String personRssj) {
		this.personRssj = personRssj;
	}

	public String getPersonTdrq() {
		return personTdrq;
	}

	public void setPersonTdrq(String personTdrq) {
		this.personTdrq = personTdrq;
	}

	public String getEnterpriseZt() {
		return enterpriseZt;
	}

	public void setEnterpriseZt(String enterpriseZt) {
		this.enterpriseZt = enterpriseZt;
	}

	public String getEnterpriseTddx() {
		return enterpriseTddx;
	}

	public void setEnterpriseTddx(String enterpriseTddx) {
		this.enterpriseTddx = enterpriseTddx;
	}

	public String getEnterpriseJyhd() {
		return enterpriseJyhd;
	}

	public void setEnterpriseJyhd(String enterpriseJyhd) {
		this.enterpriseJyhd = enterpriseJyhd;
	}

	public String getResultGetType() {
		return resultGetType;
	}

	public void setResultGetType(String resultGetType) {
		this.resultGetType = resultGetType;
	}

	public String getResultSendTime() {
		return resultSendTime;
	}

	public void setResultSendTime(String resultSendTime) {
		this.resultSendTime = resultSendTime;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getCountLimitDesc() {
		return countLimitDesc;
	}

	public void setCountLimitDesc(String countLimitDesc) {
		this.countLimitDesc = countLimitDesc;
	}

	public Integer getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public String getMediationServices() {
		return mediationServices;
	}

	public void setMediationServices(String mediationServices) {
		this.mediationServices = mediationServices;
	}

	public String getPermissionsDivision() {
		return permissionsDivision;
	}

	public void setPermissionsDivision(String permissionsDivision) {
		this.permissionsDivision = permissionsDivision;
	}

	public String getPerformContent() {
		return performContent;
	}

	public void setPerformContent(String performContent) {
		this.performContent = performContent;
	}

	public String getPerformLevel() {
		return performLevel;
	}

	public void setPerformLevel(String performLevel) {
		this.performLevel = performLevel;
	}

	public String getRunSystem() {
		return runSystem;
	}

	public void setRunSystem(String runSystem) {
		this.runSystem = runSystem;
	}

	public String getHandleScope() {
		return handleScope;
	}

	public void setHandleScope(String handleScope) {
		this.handleScope = handleScope;
	}



	public String getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(String powerSource) {
		this.powerSource = powerSource;
	}

	public String getPowerFeatures() {
		return powerFeatures;
	}

	public void setPowerFeatures(String powerFeatures) {
		this.powerFeatures = powerFeatures;
	}

	public String getLeadDepts() {
		return leadDepts;
	}

	public void setLeadDepts(String leadDepts) {
		this.leadDepts = leadDepts;
	}

	public String getWinDesc() {
		return winDesc;
	}

	public void setWinDesc(String winDesc) {
		this.winDesc = winDesc;
	}

	public String getWinMemo() {
		return winMemo;
	}

	public void setWinMemo(String winMemo) {
		this.winMemo = winMemo;
	}

	public String getMapPosition() {
		return mapPosition;
	}

	public void setMapPosition(String mapPosition) {
		this.mapPosition = mapPosition;
	}

	public String getTrafficGuide() {
		return trafficGuide;
	}

	public void setTrafficGuide(String trafficGuide) {
		this.trafficGuide = trafficGuide;
	}

	public String getFirstOffice() {
		return firstOffice;
	}

	public void setFirstOffice(String firstOffice) {
		this.firstOffice = firstOffice;
	}

	public String getSecondOffice() {
		return secondOffice;
	}

	public void setSecondOffice(String secondOffice) {
		this.secondOffice = secondOffice;
	}

	public String getOfficeTime() {
		return officeTime;
	}

	public void setOfficeTime(String officeTime) {
		this.officeTime = officeTime;
	}

	public String getContactMan() {
		return contactMan;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAskMode() {
		return askMode;
	}

	public void setAskMode(String askMode) {
		this.askMode = askMode;
	}

	public String getAskPhone() {
		return askPhone;
	}

	public void setAskPhone(String askPhone) {
		this.askPhone = askPhone;
	}

	public String getMonitorMode() {
		return monitorMode;
	}

	public void setMonitorMode(String monitorMode) {
		this.monitorMode = monitorMode;
	}

	public String getMonitorPhone() {
		return monitorPhone;
	}

	public void setMonitorPhone(String monitorPhone) {
		this.monitorPhone = monitorPhone;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceService() {
		return sourceService;
	}

	public void setSourceService(String sourceService) {
		this.sourceService = sourceService;
	}

	public Integer getSortid() {
		return sortid;
	}

	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAppUnid() {
		return appUnid;
	}

	public void setAppUnid(String appUnid) {
		this.appUnid = appUnid;
	}

	public JSONObject getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(JSONObject extInfo) {
		this.extInfo = extInfo;
	}

	public List<ApasMaterial> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<ApasMaterial> materialList) {
		this.materialList = materialList;
	}

	public String getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getChargeDesc() {
		return chargeDesc;
	}

	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}

	public String getChargeStandard() {
		return chargeStandard;
	}

	public void setChargeStandard(String chargeStandard) {
		this.chargeStandard = chargeStandard;
	}



}