package com.meng.store.service;

import com.meng.store.exception.CustomException;
import com.meng.store.model.dao.FileDao;
import com.meng.store.module.result.ResultBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface OssService {
    FileDao fileUpload(MultipartFile file, @RequestParam("env") String env);
    List<FileDao> filesUpload(List<MultipartFile> files, @RequestParam("env") String env);
    int deleteFile(String path) throws CustomException; // 删除文件
    int copyFile(String path) throws CustomException; // 复制文件
//    ResultBody fileDownload(String path);
}
