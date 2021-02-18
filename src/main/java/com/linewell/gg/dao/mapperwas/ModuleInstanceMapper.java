package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ModuleInstance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ModuleInstanceMapper {

    @Insert("insert into module_instance (unid,module_name,module_unid,apply_name,apply_idcard,apply_phone,postcode,contact_name,contact_phone,project_name,create_time,apply_type,legalman,contact_idcard,address,memo,serviceids,materialids)" +
            "values(#{unid},#{module_name},#{module_unid},#{apply_name},#{apply_idcard},#{apply_phone},#{postcode},#{contact_name},#{contact_phone},#{project_name},#{create_time},#{apply_type},#{legalman},#{contact_idcard},#{address},#{memo},#{serviceids},#{materialids})")
    int addModuleInstancese(ModuleInstance moduleInstance);

    @Update("update module_instance " +
            " set module_name = #{module_name}," +
            "  module_unid = #{module_unid}," +
            "  apply_name = #{apply_name}," +
            "  apply_idcard = #{apply_idcard}," +
            "  apply_phone = #{apply_phone}," +
            "  postcode = #{postcode}," +
            "  contact_name = #{contact_name}," +
            "  contact_phone = #{contact_phone}," +
            "  project_name = #{project_name}," +
            "  apply_type = #{apply_type}," +
            "  legalman = #{legalman}," +
            "  contact_idcard = #{contact_idcard}," +
            "  address = #{address}," +
            "  memo = #{memo} " +
            "where unid = #{unid}")
    int updateModuleInstancese(ModuleInstance moduleInstance);

    @Select("select * from module_instance where unid = #{unid}")
    ModuleInstance getModuleInstanceByUnid(String unid);

}
