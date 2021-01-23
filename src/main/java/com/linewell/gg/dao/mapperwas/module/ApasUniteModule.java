package com.linewell.gg.dao.mapperwas.module;

/**
 * 一件事模型实体类
 */
public class ApasUniteModule {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String unid;

    /**
     * 模板名称
     */
    private String moduleName;

    /**
     * 模板类型
     */
    private String moduleType;

    /**
     * 模板标签
     */
    private String moduleClassTag;

    /**
     * 主办部门UNID
     */
    private String deptUnid;

    /**
     * 主办部门名称
     */
    private String deptName;

    /**
     * 所属地区编码
     */
    private String areaCode;

    /**
     * 所属地区名称
     */
    private String areaName;

    /**
     * 承诺天数
     */
    private int promiseDay;

    /**
     * 是否发布 Y是 N否
     */
    private String isPublish;

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 最多去现场次数
     */
    private int sceneNum;

    /**
     * 外部申报地址
     */
    private String url;

    /**
     * 图标
     */
    private String modulePic;

    /**
     * 图标选中
     */
    private String modulePicActive;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleClassTag() {
        return moduleClassTag;
    }

    public void setModuleClassTag(String moduleClassTag) {
        this.moduleClassTag = moduleClassTag;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getPromiseDay() {
        return promiseDay;
    }

    public void setPromiseDay(int promiseDay) {
        this.promiseDay = promiseDay;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getSceneNum() {
        return sceneNum;
    }

    public void setSceneNum(int sceneNum) {
        this.sceneNum = sceneNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModulePic() {
        return modulePic;
    }

    public void setModulePic(String modulePic) {
        this.modulePic = modulePic;
    }

    public String getModulePicActive() {
        return modulePicActive;
    }

    public void setModulePicActive(String modulePicActive) {
        this.modulePicActive = modulePicActive;
    }
}
