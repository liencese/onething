package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApasMaterialMapper {

    @Select("select * from apas_service_material where serviceid = #{ServiceId}")
    List<ApasMaterial> getApasMaterialByServiceId(String ServiceId);

    @Select({"<script>select * from apas_service_material where unid in "
            +"<foreach collection='unids' item='unid' index='index' open='(' close=')' separator=','>"
            +"#{unid}"
            +"</foreach>"
            +"</script>"})
    List<ApasMaterial> getApasMaterialByUnids(String[] unids);

    @Select("select * from apas_service_material where unid = #{unid}")
    ApasMaterial getApasMaterialByUnid(String unid);

}
