package com.meng.store.auth.controller;

import com.meng.store.auth.model.body.LoginBody;
import com.meng.store.auth.model.body.RegisterBody;
import com.meng.store.auth.service.AccountService;
import com.meng.store.auth.model.dto.AccountDao;
import com.meng.store.module.result.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */

@RestController
@RequestMapping("/account2")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class AccountController {
    @Autowired
    AccountService accountService;

    // 注册
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBody register(@RequestBody RegisterBody body) throws Exception {
        AccountDao user = accountService.register(body);
        return ResultBody.success(user);
    }

    // 登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBody login(@RequestBody LoginBody body) throws Exception {
        AccountDao user = accountService.login(body);
        return ResultBody.success(user);
    }

    // 退出登陆
    @RequestMapping(value = "logout")
    public ResultBody logout(@RequestHeader("token") String token) {
        int code = accountService.logout(token);
        return ResultBody.success(code);
    }

    // 更新资料
    @RequestMapping(value = "update")
    public ResultBody update(@RequestHeader("token") String token, @RequestBody RegisterBody body) {
        int code = accountService.update(token, body);
        return ResultBody.success(code);
    }

    // 重置账号
    @RequestMapping(value = "reset")
    public ResultBody reset(@RequestBody LoginBody body) {
        int code = accountService.reset(body);
        return ResultBody.success(code);
    }

    // 所有账号
    @RequestMapping(value = "users")
    public ResultBody allAccount(@RequestHeader("token") String token) {
        return ResultBody.success("list");
    }
}
