package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasMaterial;
import com.linewell.gg.dao.mapperwas.module.ModuleMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModuleMaterialMapper {

    @Select("select * from module_material where module_unid = #{moduleUnid}")
    List<ModuleMaterial> getModuleMaterialByModuleUnid(String moduleUnid);

}
