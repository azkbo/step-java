package com.meng.store.controller;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.body.PublishBody;
import com.meng.store.model.dao.NewestDao;
import com.meng.store.model.dto.PublishDto;
import com.meng.store.module.result.ResultBody;
import com.meng.store.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 * 版本分三种状态：上传，预览，提审，发布/上线
 *
 */
@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    PublishService publishService;

    // 添加上传记录
    @RequestMapping(value = "create", method = RequestMethod.POST)
    private ResultBody createRecord(@RequestHeader("token") String token, @RequestBody PublishBody body) throws CustomException {
        long id = publishService.createRecord(token, body);
        return ResultBody.success(id);
    }

    // 查询上传记录
    @RequestMapping(value = "list", method = RequestMethod.POST)
    private ResultBody queryRecord(@RequestBody ListBody body) throws CustomException {
        List<PublishDto> list = publishService.queryRecord(body);
        return ResultBody.success(list);
    }

    // 删除上传记录
    @RequestMapping("delete")
    public ResultBody deleteRecord(@RequestHeader("token") String token, @RequestParam("id") int id) {
        int code = publishService.deleteRecord(token, id);
        return ResultBody.success(code);
    }

    // 设置当前记录为最新版本
    @RequestMapping("assign")
    public ResultBody assignVersion(@RequestHeader("token") String token, @RequestParam("id") int id) {
        int code = publishService.assignVersion(token, id);
        return ResultBody.success(code);
    }

    // 获取最新上传记录
    @RequestMapping("latest")
    public ResultBody getLatest(@RequestParam("aid") int aid, @RequestParam("env") String env) {
        PublishDto dao = publishService.getLatest(aid, env);
        return ResultBody.success(dao);
    }

    // 获取最新上传记录
    @RequestMapping("newest")
    public ResultBody getNewest(@RequestParam("aid") int aid) {
        NewestDao dao = publishService.getNewestVersion(aid);
        return ResultBody.success(dao);
    }
}
