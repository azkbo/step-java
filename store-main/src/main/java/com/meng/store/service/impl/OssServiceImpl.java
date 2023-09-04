package com.meng.store.service.impl;

import com.aliyun.oss.OSS;
import com.meng.store.exception.CustomException;
import com.meng.store.exception.ErrorCode;
import com.meng.store.model.dao.FileDao;
import com.meng.store.module.OssInst;
import com.meng.store.service.OssService;
import com.meng.store.utils.DateTools;
import com.meng.store.utils.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class OssServiceImpl implements OssService {
    private OSS ossClient;
    private static final String APP_FOLDER = "app_package";

    public OssServiceImpl() {
//        ossClient = OssInst.initOSS();
//        OssInst.createBucket(ossClient);
    }

    @Override
    public List<FileDao> filesUpload(List<MultipartFile> files, String env) {
        return null;
    }

    @Override
    public FileDao fileUpload(MultipartFile file, String env) {
        FileDao dto = null;
        try {
//            System.out.println(file.getName());
//            System.out.println(file.getOriginalFilename());
            String fileName = file.getOriginalFilename();
            int lastPoint = fileName.contains(".") ? fileName.lastIndexOf(".") : fileName.lastIndexOf(" ");
            String fileFolder = fileName.substring(0, lastPoint);
            String appType = fileName.substring(lastPoint + 1);
            String code = DateTools.formatVer();
            String savePath = String.format("%s/%s/%s/%s/v%s&%s", APP_FOLDER, env, appType, fileFolder, code, fileName);
            String fileUrl = OssInst.saveFile(ossClient, file.getInputStream(), savePath);
//            savePath = FileUtil.saveFile(fileName, file.getInputStream());
            dto = new FileDao(fileName, savePath, fileUrl, fileFolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public int copyFile(String path) throws CustomException {
        if(TextUtils.empty(path)) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }

        String[] paths = path.split("&");
        int len = paths[0].lastIndexOf('/') + 1;
        String versionPath = paths[0].substring(0, len) + paths[1];

        deleteFile(versionPath); // 先删除

        int code = OssInst.copyFile(ossClient, path, versionPath);
        return code;
    }

    @Override
    public int deleteFile(String path) throws CustomException {
        if(TextUtils.empty(path)) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        int code = OssInst.deleteFile(ossClient, path);
        return code;
    }
}
