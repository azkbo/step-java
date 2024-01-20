package com.mdx.hubing.controller;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.EventBody;
import com.mdx.hubing.model.body.ListBody;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 消息模版相关
 */

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService service;

    // 创建事件
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody addEvent(@RequestBody() EventBody body) throws CustomException {
        return ResultBody.success(service.addEvent(body));
    }

    // 获取列表
    @RequestMapping(value = "list")
    public ResultBody queryList(@RequestParam("sid") int sid) throws CustomException {
        return ResultBody.success(service.queryEvents(sid));
    }

    // 获取详情
    @RequestMapping("detail")
    public ResultBody getDetail(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.eventDetail(id));
    }

    // 更新信息
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBody updateEvent(@RequestBody() EventBody body) throws CustomException {
        return ResultBody.success(service.updateEvent(body));
    }

    // 删除
    @RequestMapping("delete")
    public ResultBody deleteEvent(@RequestParam("id") int id) throws CustomException {
        return ResultBody.success(service.deleteEvent(id));
    }

}
