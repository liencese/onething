package com.linewell.gg.dao.mapperwas.module;

import java.util.List;

public class ModuleService {

    //private static final long serialVersionUID = 1L;

    private String unid;
    private String module_unid;
    private String serviceid;
    private String pre_serviceid;
    private int is_start;
    private String service_name;
    private int left2;
    private int id;
    private int pre_id;
    private int top;
    private int width;
    private int height;
    private String type;
    private String alt;

    private List<ApasMaterial> apasMaterialList;//原材料

    private List<ApasMaterial> apasMaterialListUnin;//统一后材料

    public List<ApasMaterial> getApasMaterialList() {
        return apasMaterialList;
    }

    public void setApasMaterialList(List<ApasMaterial> apasMaterialList) {
        this.apasMaterialList = apasMaterialList;
    }

    public List<ApasMaterial> getApasMaterialListUnin() {
        return apasMaterialListUnin;
    }

    public void setApasMaterialListUnin(List<ApasMaterial> apasMaterialListUnin) {
        this.apasMaterialListUnin = apasMaterialListUnin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getModule_unid() {
        return module_unid;
    }

    public void setModule_unid(String module_unid) {
        this.module_unid = module_unid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getPre_serviceid() {
        return pre_serviceid;
    }

    public void setPre_serviceid(String pre_serviceid) {
        this.pre_serviceid = pre_serviceid;
    }

    public int getIs_start() {
        return is_start;
    }

    public void setIs_start(int is_start) {
        this.is_start = is_start;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getLeft2() {
        return left2;
    }

    public void setLeft2(int left2) {
        this.left2 = left2;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
