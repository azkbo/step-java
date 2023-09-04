package com.meng.store.controller;

import com.meng.store.exception.CustomException;
import com.meng.store.module.result.ResultBody;
import com.meng.store.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@RestController
@RequestMapping("file")
public class OssController {
    @Autowired
    OssService ossService;

    // 上传文件
    @RequestMapping("/upload")
    public ResultBody fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("env") String env) {
        return ResultBody.success(ossService.fileUpload(file, env));
    }

    // 删除文件
    @RequestMapping("/delete")
    ResultBody deleteFile(@RequestParam("path") String path) throws CustomException {
        int code = ossService.deleteFile(path);
        return code == 0 ? ResultBody.success("成功") : ResultBody.fail(code, "失败！");
    }

    // 复制文件
    @RequestMapping("/copy")
    ResultBody copyFile(@RequestParam("path") String path) throws CustomException {
        int code = ossService.copyFile(path);
        return code == 0 ? ResultBody.success("成功") : ResultBody.fail(code, "失败！");
    }

    // 下载
    @RequestMapping("/download")
    public ResultBody fileDownload(@RequestParam("name") String fileName) {

        return ResultBody.fail(-3, "下载失败！");
    }
}
