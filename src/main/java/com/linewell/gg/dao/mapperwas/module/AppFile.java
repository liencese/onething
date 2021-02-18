package com.linewell.gg.dao.mapperwas.module;

import java.io.Serializable;
import java.sql.Blob;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * <p>
 * AppFile实体
 * </p>
 */
@Document(collection="app_file")
public class AppFile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * 主键
	 */
	@Field("FILE_UNID")
	private String file_unid;
	
	/**
	 * 文件名称
	 */
	@Field("FILE_NAME")
	private String file_name;
	
	/**
	 * 文件MD5值
	 */
	@Field("FILE_MD5")
	private String file_md5;

	/**
	 * 文件存放路径
	 */
	@Field("FILE_PATH")
	private String file_path;

	@Field("FILE_PWD")
	private String file_pwd;
	
	/**
	 * 文件扩展名
	 */
	@Field("FILE_EXT")
	private String file_ext;
	
	/**
	 * 文件创建时间
	 */
	@Field("FILE_CREATETIME")
	private String file_createtime;
	
	/**
	 * 文件大小
	 */
	@Field("FILE_SIZE")
	private String file_size;
	
	/**
	 * 文件数据库存放值
	 */
	@Field("FILE_DATA")
	private Blob file_data ;
	
	/**
	 * 文件状态(Y.有效;N.无效)
	 */
	@Field("FILE_STATE")
	private String file_state="Y";
		
	/**
	 * 文件保存类型(0.磁盘和数据库  1.磁盘  2.数据库)
	 */
	@Field("FILE_SAVE_TYPE")
	private String file_save_type;
		
	/**
	 * 文件附属于
	 */
	@Field("FILE_BELONGTO")
	private String file_belongto;
		


	/**
	 * 获取
	 * @return String
	 */
	public String getFile_unid() {
		return file_unid;
	}

	/**
	 * 设置
	 * @param file_unid
	 *               String 
	 */
	public void setFile_unid(String file_unid) {
		this.file_unid = file_unid;
	}
	
	/**
	 * 获取文件名称
	 * @return String
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * 设置文件名称
	 * @param file_name
	 *               String 文件名称
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	/**
	 * 获取文件MD5值
	 * @return String
	 */
	public String getFile_md5() {
		return file_md5;
	}

	/**
	 * 设置文件MD5值
	 * @param file_md5
	 *               String 文件MD5值
	 */
	public void setFile_md5(String file_md5) {
		this.file_md5 = file_md5;
	}
	
	/**
	 * 获取文件存放路径
	 * @return String
	 */
	public String getFile_path() {
		return file_path;
	}

	/**
	 * 设置文件存放路径
	 * @param file_path
	 *               String 文件存放路径
	 */
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	/**
	 * 获取文件扩展名
	 * @return String
	 */
	public String getFile_ext() {
		return file_ext;
	}

	/**
	 * 设置文件扩展名
	 * @param file_ext
	 *               String 文件扩展名
	 */
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	
	/**
	 * 获取文件创建时间
	 * @return String
	 */
	public String getFile_createtime() {
		return file_createtime;
	}

	/**
	 * 设置文件创建时间
	 * @param file_createtime
	 *               String 文件创建时间
	 */
	public void setFile_createtime(String file_createtime) {
		this.file_createtime = file_createtime;
	}
	
	/**
	 * 获取文件大小
	 * @return String
	 */
	public String getFile_size() {
		return file_size;
	}

	/**
	 * 设置文件大小
	 * @param file_size
	 *               String 文件大小
	 */
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	
	/**
	 * 获取文件数据库存放值
	 * @return Blob
	 */
	public Blob getFile_data() {
		return file_data;
	}

	/**
	 * 设置文件数据库存放值
	 * @param file_data
	 *               Blob 文件数据库存放值
	 */
	public void setFile_data(Blob file_data) {
		this.file_data = file_data;
	}
	
	/**
	 * 获取文件状态：Y.有效  N.无效
	 * @return String
	 */
	public String getFile_state() {
		return file_state;
	}

	/**
	 * 设置文件状态：Y.有效  N.无效
	 * @param file_state
	 *               String 文件状态：Y.有效  N.无效
	 */
	public void setFile_state(String file_state) {
		this.file_state = file_state;
	}
	
	/**
	 * 获取文件保存类型：0.磁盘和数据库  1.磁盘  2.数据库
	 * @return String
	 */
	public String getFile_save_type() {
		return file_save_type;
	}

	/**
	 * 设置文件保存类型：0.磁盘和数据库  1.磁盘  2.数据库
	 * @param file_save_type
	 *               String 文件保存类型：0.磁盘和数据库  1.磁盘  2.数据库
	 */
	public void setFile_save_type(String file_save_type) {
		this.file_save_type = file_save_type;
	}
	
	/**
	 * 获取文件附属于
	 * @return String
	 */
	public String getFile_belongto() {
		return file_belongto;
	}

	/**
	 * 设置文件附属于
	 * @param file_belongto
	 *               String 文件附属于
	 */
	public void setFile_belongto(String file_belongto) {
		this.file_belongto = file_belongto;
	}

	public String getFile_pwd() {
		return file_pwd;
	}

	public void setFile_pwd(String file_pwd) {
		this.file_pwd = file_pwd;
	}


}

