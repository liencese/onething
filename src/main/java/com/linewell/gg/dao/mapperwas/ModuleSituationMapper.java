package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.ModuleSituation;
import jodd.madvoc.meta.In;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModuleSituationMapper {

    @Insert("insert into module_situation (unid,module_unid,question,answer1,answer2,sortid,createtime) values (#{unid},#{moduleUnid},#{question},#{answer1},#{answer2},#{sortid},#{createtime})")
    int addModuleSituation(ModuleSituation moduleSituation);

    @Update("update module_situation set answer1_sids = #{answer1Sids},answer2_sids = #{answer2Sids},answer1_mids = #{answer1Mids},answer2_mids = #{answer2Mids} where unid = #{unid}")
    int updateModuleSituation(ModuleSituation moduleSituation);

    @Select("select a.*,a.module_unid moduleUnid,a.answer1_sids answer1Sids,a.answer2_sids answer2Sids,a.answer1_mids answer1Mids,a.answer2_mids answer2Mids from module_situation a where module_unid = #{moduleUnid} order by createtime")
    List<ModuleSituation> getAllModuleSituationByModuleUnid(String moduleUnid);

    @Delete("delete from module_situation where unid = #{unid}")
    int deleteModuleSituation(String unid);

}
