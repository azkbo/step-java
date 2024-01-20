package com.mdx.hubing.controller;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.ListBody;
import com.mdx.hubing.model.body.ShopBody;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 商店相关
 */

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopService service;

    // 创建事件
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody addShop(@RequestBody() ShopBody body) throws CustomException {
        return ResultBody.success(service.addShop(body));
    }

    // 获取列表
    @RequestMapping(value = "list")
    public ResultBody queryList(@RequestParam(value = "uid", required = false) int uid) throws CustomException {
        return ResultBody.success(service.queryShops(uid));
    }

    // 获取详情
    @RequestMapping("detail")
    public ResultBody getDetail(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.shopDetail(id));
    }

    // 更新信息
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody updateShop(@RequestBody()ShopBody body) throws CustomException {
        return ResultBody.success(service.updateShop(body));
    }

    // 删除
    @RequestMapping("delete")
    public ResultBody deleteShop(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.deleteShop(id));
    }

}
