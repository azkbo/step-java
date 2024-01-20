package com.mdx.hubing.controller;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.entity.FeedbackEntity;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.StaffService;
import com.mdx.hubing.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 商品相关
 */

@RestController
@RequestMapping("/client")
public class SystemController {
    @Autowired
    SystemService service;

    // 创建事件
    @RequestMapping(value = "feedback", method = RequestMethod.POST)
    public ResultBody addFeedback(@RequestBody() FeedbackEntity body) throws CustomException {
        return ResultBody.success(service.addFeedback(body));
    }

    // 创建事件
    @RequestMapping(value = "queryFeedback")
    public ResultBody queryFeedback() throws CustomException {
        return ResultBody.success(service.queryFeedback());
    }

}
