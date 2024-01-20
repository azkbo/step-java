package com.mdx.hubing.controller;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.ListBody;
import com.mdx.hubing.model.body.SeatBody;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 订单相关
 */

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService service;


    // 创建事件
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody addSeat(@RequestBody() SeatBody body) throws CustomException {
        return ResultBody.success(service.addSeat(body));
    }

    // 获取列表
    @RequestMapping(value = "list")
    public ResultBody queryList(@RequestParam("sid") int sid) throws CustomException {
        return ResultBody.success(service.querySeats(sid));
    }

    // 获取详情
    @RequestMapping("detail")
    public ResultBody getDetail(@RequestParam(value = "id") int id) throws CustomException {
        return ResultBody.success(service.seatDetail(id));
    }

    // 更新信息
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody updateSeat(@RequestBody() SeatBody body) throws CustomException {
        return ResultBody.success(service.updateSeat(body));
    }

    // 删除
    @RequestMapping("delete")
    public ResultBody deleteSeat(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.deleteSeat(id));
    }

}
