package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.LoginBody;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.dto.WxResult;
import com.mdx.hubing.model.entity.AccountEntity;
import com.mdx.hubing.model.mapper.AccountMapper;
import com.mdx.hubing.module.api.WxApis;
import com.mdx.hubing.module.network.ResultData;
import com.mdx.hubing.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 账号服务
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    /**
     * 注册
     */
    @Override
    public AccountEntity register(LoginBody body) {
        int id = 0;
        try {
            id = accountMapper.query(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        if (id > 0) {
//            throw CustomException.create(ErrorCode.ACCOUNT_EXIST);
//        }
        return null;
    }

    @Override
    public AccountDao login(LoginBody body) {
        AccountDao account = accountMapper.login(body);

        return account;
    }

    /**
     * 微信注册
     */
    @Override
    public AccountDao wxLogin(LoginBody body) throws CustomException {
        if (body.sign == null) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        WxResult data = new WxApis().getWxOpenid(body.sign);
        if (data == null || data.openid == null) {
            throw CustomException.create(ErrorCode.WX_ACCOUNT);
        } else {
            body.sign = data.openid;
        }
        // 获取账号
        AccountDao account = null;
        try {
            account = accountMapper.queryByCode(data.openid);
            System.out.println(account);
            // 没有注册账号
            if (account == null) {
                int size = accountMapper.accountNum();
//                System.out.println(body);
                AccountEntity entity = new AccountEntity();
                entity.setUid(100000 + size);
                entity.setSign(body.sign);
                entity.setNickname(body.nickname);
                entity.setIcon(body.icon);
                entity.setPwd(body.pwd);
                entity.setPhone(body.phone);
//                BeanUtils.copyProperties(body, entity);
                System.out.println(entity);
                accountMapper.register(entity);
                account = accountMapper.queryByCode(data.openid);
                System.out.println(account);
            }
        } catch (Exception e) {
            throw CustomException.create(ErrorCode.LOGIN_ERR);
        }
        return account;
    }

    @Override
    public int update(LoginBody body) {
        int code = 0;
        try{
            System.out.println(body);
            code = accountMapper.updateAccount(body);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public int reset(LoginBody body) {
        return 0;
    }

    @Override
    public int logout(String token) {
        return accountMapper.logout(0);
    }

    @Override
    public int delete(String token) {
        return 0;
    }

    @Override
    public ArrayList<AccountDao> accountAll() {
        return accountMapper.accountAll();
    }
}
