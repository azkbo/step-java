package com.mdx.hubing.controller;

import com.mdx.hubing.model.body.*;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.entity.AccountEntity;
import com.mdx.hubing.module.result.ResultBody;
import com.mdx.hubing.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 账号
 */

@RestController
@RequestMapping("/account")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class AccountController {
    @Autowired
    AccountService service;

    // 注册
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBody register(@RequestBody LoginBody body) throws Exception {
        AccountEntity user = service.register(body);
        return ResultBody.success(user);
    }

    // 登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBody login(@RequestBody LoginBody body) throws Exception {
        AccountDao user = service.login(body);
        return ResultBody.success(user);
    }

    // 登陆
    @RequestMapping(value = "wxLogin", method = RequestMethod.POST)
    public ResultBody wxLogin(@RequestBody LoginBody body) throws Exception {
        AccountDao user = service.wxLogin(body);
        return ResultBody.success(user);
    }

    // 退出登陆
    @RequestMapping(value = "logout")
    public ResultBody logout(@RequestHeader("token") String token) {
        int code = service.logout(token);
        return ResultBody.success(code);
    }

    // 更新资料
    @RequestMapping(value = "update")
    public ResultBody update(@RequestBody LoginBody body) throws Exception {
        int code = service.update(body);
        return ResultBody.success(code);
    }

    // 重置账号
    @RequestMapping(value = "reset")
    public ResultBody reset(@RequestBody LoginBody body) throws Exception {
        int code = service.reset(body);
        return ResultBody.success(code);
    }

    // 重置账号
    @RequestMapping(value = "query")
    public ResultBody accountAll() {
        List<AccountDao> accounts = service.accountAll();
        return ResultBody.success(accounts);
    }

}
