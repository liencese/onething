package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApasServiceMapper {

    @Select({"<script>select servicename,infoprojid,deptunid,deptname from apas_service "
            +" where servicetype is not null and deptunid like '%321311%'"
            +"<when test='param!=null'>"
            +" and servicename like '%${param}%' or infoprojid = #{param}"
            +"</when>"
            +" limit 50</script>"})
    List<ApasService> getApasServiceByNameOrCode(String param);

    @Select("<script>"
            + "select * from apas_service where infoprojid in "
            + "<foreach item='item' index='index' collection='infoprojids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<ApasService> getApasServiceByInfoprojids(String[] infoprojids);

    @Select("select * from  apas_service where showtype = 2 and infoprojid = #{infoprojid}")
    ApasService getApasServiceByInfoprojid(String infoProjid);

}
