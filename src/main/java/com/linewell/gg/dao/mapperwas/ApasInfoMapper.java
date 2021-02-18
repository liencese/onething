package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
public interface ApasInfoMapper {

    @Select({"select f_createprojid(#{servicecode},#{datetime})"})
    int getProjidindex(String servicecode, String datetime);



    @Insert("insert into apas_info(" +
            "unid," +
            "moduleUnid," +
            "applyname," +
            "phone," +
            "mobile," +
            "idcard," +
            "idcard_type, " +
            "legalman," +
            "contactman," +
            "address," +
            "contact_idcard, " +
            "servicetype," +
            "projid," +
            "contact_idcard_type, " +
            "receive_deptid, " +
            "receive_deptname," +
            "create_time, " +
            "handlestate," +
            "projectname," +
            "applyfrom," +
            "serviceid," +
            "servicecode," +
            "servicename," +
            "promiseday," +
            "apply_type," +
            "memo) " +
            "values(" +
            "#{unid}," +
            "#{moduleUnid}," +
            "#{applyname}," +
            "#{phone}," +
            "#{mobile}," +
            "#{idcard}," +
            "#{idcardType}," +
            "#{legalman}," +
            "#{contactman}," +
            "#{address}," +
            "#{contactIdcard}," +
            "#{servicetype}," +
            "#{projid}," +
            "#{contactIdcardType}, " +
            "#{receiveDeptid}," +
            "#{receiveDeptname}," +
            "#{createTime}," +
            "#{handlestate}," +
            "#{projectname}," +
            "#{applyfrom}," +
            "#{serviceid}," +
            "#{servicecode}," +
            "#{servicename}," +
            "#{promiseday}," +
            "#{applyType}," +
            "#{memo})")
    int addApasInfo(ApasInfo apasInfo);


    @Select("select * from apas_info where moduleUnid = #{moduleInstanceUnid} and servicecode = #{servicecode}")
    ApasInfo getApasInfoByModuleService(String moduleInstanceUnid,String servicecode);

    @Update("update apas_info set next_unid = #{nextUnid} where unid = #{unid}")
    void updateApasInfo(ApasInfo apasInfo);
}
