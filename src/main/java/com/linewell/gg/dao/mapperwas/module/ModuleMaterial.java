package com.linewell.gg.dao.mapperwas.module;

import java.util.List;

public class ModuleMaterial {

    private String unid;
    private String module_unid;//模板id
    private String materialids;//合并前材料id,以,分割
    private String material_rid;//合并后的材料id

    private ApasMaterial apasMaterial_r;//合并后材料

    private List<ApasMaterial> apasMaterialList;//原材料

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

    public String getMaterialids() {
        return materialids;
    }

    public void setMaterialids(String materialids) {
        this.materialids = materialids;
    }

    public String getMaterial_rid() {
        return material_rid;
    }

    public void setMaterial_rid(String material_rid) {
        this.material_rid = material_rid;
    }

    public ApasMaterial getApasMaterial_r() {
        return apasMaterial_r;
    }

    public void setApasMaterial_r(ApasMaterial apasMaterial_r) {
        this.apasMaterial_r = apasMaterial_r;
    }

    public List<ApasMaterial> getApasMaterialList() {
        return apasMaterialList;
    }

    public void setApasMaterialList(List<ApasMaterial> apasMaterialList) {
        this.apasMaterialList = apasMaterialList;
    }
}
