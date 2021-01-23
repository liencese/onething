package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ModuleService;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModuleServiceMapper {

    @Insert("insert into module_service(unid,module_unid,serviceid,pre_serviceid,is_start,service_name,id,pre_id,left2,top,type,width,height,alt)" +
            "values(#{unid},#{module_unid},#{serviceid},#{pre_serviceid},#{is_start},#{service_name},#{id},#{pre_id},#{left2},#{top},#{type},#{width},#{height},#{alt})")
    int add(ModuleService moduleService);

    @Select("select * from module_service where module_unid = #{module_unid}")
    List<ModuleService> getModuleServiceByModuleUnid(String module_unid);

    @Delete("delete from module_service where module_unid = #{module_unid}")
    int deleteByModuleUnid(String module_unid);
}
