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

    private String unid;
    private String serviceid;
    private String servicename;
    private String infoname;
    private String type;
    private String memo;
    private String createtime;
    private String sub_materialid;
    private String sortid;
    private String state;
    private String code;
    private String pagenum;
    private String pagecopynum;
    private String need_electronic;
    private String affixtype;
    private String phase;
    private String gettype_unids;
    private String materialguid;
    private String necessity_desc;
    private String format;
    private String detail_requirement;
    private String from_unid;
    private String parent_materialunid;

    private String material_rid;//合并后的材料id

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getInfoname() {
        return infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSub_materialid() {
        return sub_materialid;
    }

    public void setSub_materialid(String sub_materialid) {
        this.sub_materialid = sub_materialid;
    }

    public String getSortid() {
        return sortid;
    }

    public void setSortid(String sortid) {
        this.sortid = sortid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPagenum() {
        return pagenum;
    }

    public void setPagenum(String pagenum) {
        this.pagenum = pagenum;
    }

    public String getPagecopynum() {
        return pagecopynum;
    }

    public void setPagecopynum(String pagecopynum) {
        this.pagecopynum = pagecopynum;
    }

    public String getNeed_electronic() {
        return need_electronic;
    }

    public void setNeed_electronic(String need_electronic) {
        this.need_electronic = need_electronic;
    }

    public String getAffixtype() {
        return affixtype;
    }

    public void setAffixtype(String affixtype) {
        this.affixtype = affixtype;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getGettype_unids() {
        return gettype_unids;
    }

    public void setGettype_unids(String gettype_unids) {
        this.gettype_unids = gettype_unids;
    }

    public String getMaterialguid() {
        return materialguid;
    }

    public void setMaterialguid(String materialguid) {
        this.materialguid = materialguid;
    }

    public String getNecessity_desc() {
        return necessity_desc;
    }

    public void setNecessity_desc(String necessity_desc) {
        this.necessity_desc = necessity_desc;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDetail_requirement() {
        return detail_requirement;
    }

    public void setDetail_requirement(String detail_requirement) {
        this.detail_requirement = detail_requirement;
    }

    public String getFrom_unid() {
        return from_unid;
    }

    public void setFrom_unid(String from_unid) {
        this.from_unid = from_unid;
    }

    public String getParent_materialunid() {
        return parent_materialunid;
    }

    public void setParent_materialunid(String parent_materialunid) {
        this.parent_materialunid = parent_materialunid;
    }

    public String getMaterial_rid() {
        return material_rid;
    }

    public void setMaterial_rid(String material_rid) {
        this.material_rid = material_rid;
    }
}
