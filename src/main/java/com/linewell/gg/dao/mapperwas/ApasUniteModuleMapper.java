package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasUniteModule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ApasUniteModuleMapper {

    @Select("select * from apas_unite_module where isPublish = 'Y'")
    List<ApasUniteModule> getAllApasUniteModule();

    @Select("select * from apas_unite_module where unid = #{unid}")
    ApasUniteModule getApasUniteModule(String unid);

    @Select({"<script>"
            +"select unid,moduleName,moduleClassTag,moduleType,promiseDay,case isPublish when 'Y' then '是' else '否' end isPublish,sceneNum from apas_unite_module where 1 = 1  "
            +"<when test='moduleName!=null'>"
            +" and moduleName like '%${moduleName}%'"
            +"</when>"
            +" order by moduleType limit #{pageNo},#{pageSize}"
            +"</script>"})
    List<ApasUniteModule> getAllApasUniteModuleWhere(String moduleName,int pageNo,int pageSize);

    @Select("select count(1) from apas_unite_module")
    int getApasUniteModuleTotal();

    @Select("select * from apas_unite_module where unid = #{moduleUnid}")
    ApasUniteModule getApasUniteModuleByUnid(String moduleUnid);

    @Update("update apas_unite_module set moduleName = #{moduleName},moduleType=#{moduleType},moduleClassTag=#{moduleClassTag},promiseDay=#{promiseDay},isPublish=#{isPublish},sceneNum=#{sceneNum},updateTime = #{updateTime} where unid = #{unid}")
    int updateApasUniteModule(ApasUniteModule apasUniteModule);

    @Insert("insert into apas_unite_module (unid,moduleName,moduleType,moduleClassTag,promiseDay,isPublish,sceneNum,createTime)"
            +" values(#{unid},#{moduleName},#{moduleType},#{moduleClassTag},#{promiseDay},#{isPublish},#{sceneNum},#{createTime})")
    int addApasUniteModule(ApasUniteModule apasUniteModule);

    @Delete("delete from apas_unite_module where unid = #{unid}")
    int deleteApasUniteModule(String unid);
}
