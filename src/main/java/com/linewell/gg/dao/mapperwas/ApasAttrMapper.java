package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ApasAttr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ApasAttrMapper {

    @Insert("insert into apas_attr (unid,punid,materialid,name,savestate,ischecked,createtime,fromshare,locked,sortid,memo,amount)" +
            "values(#{unid},#{punid},#{materialid},#{name},#{savestate},#{ischecked},#{createtime},#{fromshare},#{locked},#{sortid},#{memo},#{amount})")
    int addApasAttr(ApasAttr apasAttr);
}
