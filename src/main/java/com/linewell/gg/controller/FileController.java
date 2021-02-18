package com.linewell.gg.controller;

import com.linewell.gg.dao.mapperwas.module.AppFile;
import com.linewell.gg.dao.mapperwas.module.ResultData;
import com.linewell.gg.service.ApplyService;
import com.linewell.gg.util.DateUtil;
import com.linewell.gg.util.StrUtil;
import com.linewell.gg.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FileController {

    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "/uploadfile")
    @ResponseBody
    public ResultData uploadfile(@RequestParam(value = "belongTo", required = false) String belongTo,
                                 @RequestParam(value = "fileFileName", required = false) String fileName,
                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                 HttpServletRequest request) {
        //文件id
        String fileUnid = UuidUtil.getUuid();
        //1、将文件上传至服务器
        String attrPath = "/";
        if (StringUtils.isEmpty(fileName)) {
            fileName = file.getOriginalFilename();
        }

        AppFile appFile = new AppFile();
        appFile.setFile_unid(fileUnid);
        appFile.setFile_name(fileName);
        appFile.setFile_path(attrPath);
        appFile.setFile_ext(fileName.substring(fileName.lastIndexOf(".") + 1));
        if (file != null) {
            appFile.setFile_size(String.valueOf(file.getSize()));
        } else if (StringUtils.isNotEmpty(request.getParameter("fileSize"))) {
            String fileSize = request.getParameter("fileSize");
            appFile.setFile_size(String.valueOf(fileSize));
        }
        appFile.setFile_createtime(DateUtil.formatDateTime(new Date()));
        appFile.setFile_belongto(belongTo);
        //附件存储类型:0.OSS和数据库; 1.OSS; 2.数据库; 3.FastDFS和数据库; 4.FastDFS;5.一张网服务器
        appFile.setFile_save_type("5");

        //保存
        applyService.addFile(appFile);

        ResultData result = new ResultData();
        result.setCode(ResultData.SUCCESS);
        result.put("unid", appFile.getFile_unid());
        result.put("fileName", fileName);
        result.put("filePath", appFile.getFile_path());
        result.put("filePwd", StringUtils.defaultIfEmpty(appFile.getFile_pwd(), "654321"));
        return result;
    }

    @RequestMapping(value = "/delFile")
    @ResponseBody
    public ResultData delFile(String fileUnid) {

        int r = applyService.delFile(fileUnid);
        ResultData result = new ResultData();
        if (r > 0) {
            result.setCode(ResultData.SUCCESS);
        } else {
            result.setCode(ResultData.FAILURE);
        }
        return result;
    }

    @RequestMapping(value = "/uploadPic")
    @ResponseBody
    public ResultData uploadPic(@RequestParam(value = "file", required = true) MultipartFile file,
                                HttpServletRequest request) {
        ResultData result = new ResultData();
        //文件id
        String fileUnid = UuidUtil.getUuid();
        //将文件上传至项目 路径：image/flow
        if (file.isEmpty()) {
            result.setCode(ResultData.FAILURE);
        } else {
            String property = System.getProperty("user.dir");

            String fileName = UuidUtil.getUuid() + "_" + file.getOriginalFilename();
            String filePath = property + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "image" + File.separator + "flow" + File.separator;
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                result.setCode(ResultData.SUCCESS);
                result.put("fileName", fileName);
                result.put("url", filePath);
            } catch (IOException e) {

            }
        }

        return result;
    }


}
