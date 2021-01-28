package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApasMaterialMapper {

    @Select("select * from apas_service_material where serviceid = (select unid from apas_service where infoprojid = #{ServiceId} limit 1)")
    List<ApasMaterial> getApasMaterialByServiceId(String ServiceId);

    @Select({"<script>select a.*,b.servicename from apas_service_material a left join apas_service b on a.serviceid = b.unid where a.unid in "
            +"<foreach collection='unids' item='unid' index='index' open='(' close=')' separator=','>"
            +"#{unid}"
            +"</foreach>"
            +"</script>"})
    List<ApasMaterial> getApasMaterialByUnids(String[] unids);

    @Select("select a.*,b.servicename from apas_service_material a left join apas_service b"
            +" on a.serviceid = b.unid"
            +" where a.unid = #{unid}")
    ApasMaterial getApasMaterialByUnid(String unid);

}
