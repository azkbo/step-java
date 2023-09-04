package com.meng.store.controller;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.AppBody;
import com.meng.store.model.body.ListBody;
import com.meng.store.module.result.ResultBody;
import com.meng.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 应用商店管理
 */

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    // 创建应用
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody createApp(@RequestHeader("token") String token, @RequestBody AppBody body) throws CustomException {
        return ResultBody.success(storeService.createApp(body, token));
    }

    // 获取应用列表
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultBody appList(@RequestBody() ListBody body) throws CustomException {
        return ResultBody.success(storeService.queryList(body));
    }

    // 获取应用详情
    @RequestMapping("detail")
    public ResultBody getAppDetail(@RequestParam(value = "id", required = false) int id, @RequestParam(value = "code", required = false) String code) throws CustomException {
        return ResultBody.success(storeService.getAppDetail(id, code));
    }

    // 更新应用信息
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody updateApp(@RequestHeader("token") String token,@RequestBody AppBody body) throws CustomException {
        return ResultBody.success(storeService.updateApp(body, token));
    }

    // 删除应用
    @RequestMapping("delete")
    public ResultBody deleteApp(@RequestHeader("token") String token, @RequestParam("id") int id) throws CustomException {
        return ResultBody.success(storeService.deleteApp(id, token));
    }

    // 获取应用数
    @RequestMapping("count")
    public ResultBody appNumber() {
        return ResultBody.success(storeService.appNumber());
    }

    // 添加上传记录
    @RequestMapping("publish")
    public ResultBody publishPackage(@RequestHeader("token") String token, AppBody body) {
        return ResultBody.success(storeService.publishPackage(body, token));
    }

}
