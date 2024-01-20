package com.mdx.hubing.controller;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.ListBody;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 商品相关
 */

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService service;


    // 创建事件
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody addStaff(@RequestBody() StaffBody body) throws CustomException {
        return ResultBody.success(service.addStaff(body));
    }

    // 获取列表
    @RequestMapping(value = "list")
    public ResultBody queryList(@RequestParam("sid") int sid) throws CustomException {
        return ResultBody.success(service.queryStaffs(sid));
    }

    // 获取详情
    @RequestMapping("detail")
    public ResultBody getDetail(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.staffDetail(id));
    }

    // 获取详情
    @RequestMapping("queryByUid")
    public ResultBody queryByUid(@RequestParam(value = "uid", required = false) int uid) throws CustomException {
        return ResultBody.success(service.queryByUid(uid));
    }

    // 更新信息
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody updateStaff(@RequestBody() StaffBody body) throws CustomException {
        return ResultBody.success(service.updateStaff(body));
    }

    // 删除
    @RequestMapping("delete")
    public ResultBody deleteStaff(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.deleteStaff(id));
    }
}
