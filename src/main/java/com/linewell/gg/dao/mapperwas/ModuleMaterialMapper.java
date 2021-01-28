package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasMaterial;
import com.linewell.gg.dao.mapperwas.module.ModuleMaterial;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModuleMaterialMapper {

    @Select("select * from module_material where module_unid = #{moduleUnid}")
    List<ModuleMaterial> getModuleMaterialByModuleUnid(String moduleUnid);

    @Insert("insert into module_material (unid,module_unid,materialids,material_rid) values (#{unid},#{module_unid},#{materialids},#{material_rid})")
    int addModuleMaterial(ModuleMaterial moduleMaterial);

    @Delete("delete from module_material where unid = #{unid}")
    int deleteModuleMaterial(String unid);

}
