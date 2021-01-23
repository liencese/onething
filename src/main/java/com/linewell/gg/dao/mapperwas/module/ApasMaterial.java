package com.linewell.gg.dao.mapperwas.module;


import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 材料配置实体
 * </P>
 */

public class ApasMaterial {
    private static final long serialVersionUID = 1L;

    /**
     * 材料主键
     */

    private String unid = "";

    /**
     * 材料分类主键
     */

    private String classifyUnids = "";


    /**
     * 审批事项主键
     */

    private String serviceUnid = "";

    /**
     * 材料编码
     */

    private String code = "";

    /**
     * 材料名称
     */

    private String name = "";


    /**
     * 材料形式
     */

    private String format = "";


    private String memo = "";


    private String getTypes = "";


    private String importLevel = "";


    private int srcNum = 0;


    private int copyNum = 0;


    private String isNeedElec = "";


    private String affixType = "";


    private String phaseType = "";


    private String necessityDesc = "";


    private String submitMedium = "";


    private String submitRequire = "";


    private String acceptRequire = "";


    private String srcWay = "";


    private String srcCode = "";


    private String proCode = "";


    private String createTime = "";


    private int sortid = 0;


    private String status = "";

    /**
     * 空白表格下载连接
     */
    private String form_url;

    /**
     * 示例样表下载链接
     */
    private String example_url;

    /**
     * 统一后材料id
     */
    private String material_rid;

    public String getMaterial_rid() {
        return material_rid;
    }

    public void setMaterial_rid(String material_rid) {
        this.material_rid = material_rid;
    }

    public String getForm_url() {
        return form_url;
    }

    public void setForm_url(String form_url) {
        this.form_url = form_url;
    }

    public String getExample_url() {
        return example_url;
    }

    public void setExample_url(String example_url) {
        this.example_url = example_url;
    }

    /**
     * @return the unid
     */
    public String getUnid() {
        return unid;
    }

    /**
     * @param unid the unid to set
     */
    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getClassifyUnids() {
        return classifyUnids;
    }

    public void setClassifyUnids(String classifyUnids) {
        this.classifyUnids = classifyUnids;
    }


    public String getServiceUnid() {
        return serviceUnid;
    }

    public void setServiceUnid(String serviceUnid) {
        this.serviceUnid = serviceUnid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGetTypes() {
        return getTypes;
    }

    public void setGetTypes(String getTypes) {
        this.getTypes = getTypes;
    }

    public String getImportLevel() {
        return importLevel;
    }

    public void setImportLevel(String importLevel) {
        this.importLevel = importLevel;
    }

    public int getSrcNum() {
        return srcNum;
    }

    public void setSrcNum(int srcNum) {
        this.srcNum = srcNum;
    }

    public int getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(int copyNum) {
        this.copyNum = copyNum;
    }

    public String getIsNeedElec() {
        return isNeedElec;
    }

    public void setIsNeedElec(String isNeedElec) {
        this.isNeedElec = isNeedElec;
    }

    public String getAffixType() {
        return affixType;
    }

    public void setAffixType(String affixType) {
        this.affixType = affixType;
    }

    public String getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(String phaseType) {
        this.phaseType = phaseType;
    }

    public String getNecessityDesc() {
        return necessityDesc;
    }

    public void setNecessityDesc(String necessityDesc) {
        this.necessityDesc = necessityDesc;
    }

    public String getSubmitMedium() {
        return submitMedium;
    }

    public void setSubmitMedium(String submitMedium) {
        this.submitMedium = submitMedium;
    }

    public String getSubmitRequire() {
        return submitRequire;
    }

    public void setSubmitRequire(String submitRequire) {
        this.submitRequire = submitRequire;
    }

    public String getAcceptRequire() {
        return acceptRequire;
    }

    public void setAcceptRequire(String acceptRequire) {
        this.acceptRequire = acceptRequire;
    }

    public String getSrcWay() {
        return srcWay;
    }

    public void setSrcWay(String srcWay) {
        this.srcWay = srcWay;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortId(int sortid) {
        this.sortid = sortid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }
}
