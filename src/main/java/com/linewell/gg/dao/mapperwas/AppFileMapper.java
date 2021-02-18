package com.linewell.gg.dao.mapperwas;

import com.linewell.gg.dao.mapperwas.module.AppFile;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AppFileMapper {

    @Insert("insert into app_file (file_unid,file_name,file_path,file_ext,file_createtime,file_size,file_save_type,file_belongto)" +
            " values(#{file_unid},#{file_name},#{file_path},#{file_ext},#{file_createtime},#{file_size},#{file_save_type},#{file_belongto})")
    int addFile(AppFile appFile);

    @Update("update app_file set file_belongto = #{file_belongto} where file_unid = #{file_unid}")
    int updateFile(String file_belongto,String file_unid);

    @Delete("delete from app_file where file_unid = #{fileUnid}")
    int delFile(String fileUnid);

    @Select("select * from app_file where file_unid = #{file_unid}")
    AppFile getFile(String file_unid);
}
