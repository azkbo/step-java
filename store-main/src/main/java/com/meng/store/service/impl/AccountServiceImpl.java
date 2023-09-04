package com.meng.store.service.impl;

import com.meng.store.exception.CustomException;
import com.meng.store.exception.ErrorCode;
import com.meng.store.model.body.LoginBody;
import com.meng.store.model.body.RegisterBody;
import com.meng.store.model.dto.AccountDao;
import com.meng.store.model.entity.AccountEntity;
import com.meng.store.model.mapper.AccountMapper;
import com.meng.store.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public AccountEntity register(RegisterBody body) throws CustomException {
        LoginBody login = new LoginBody();
        login.email = body.email;
        login.phone = body.phone;
        int id = 0;
        try {
            id = accountMapper.query(login);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id > 0) {
            throw CustomException.create(ErrorCode.ACCOUNT_EXIST);
        }
        AccountEntity account = new AccountEntity();
        Random random = new Random();
        account.uid = random.nextInt(100000000);
        account.email = body.email;
        account.wxId = body.wxId;
        account.icon = body.icon;
        account.password = body.password;
        account.nickname = body.name;
        account.id = accountMapper.register(account);

        System.out.println(account.id);
        return account;
    }

    @Override
    public AccountDao login(LoginBody body) {
        AccountDao account = accountMapper.login(body);

        return account;
    }

    @Override
    public int update(String token, RegisterBody body) {
        return 0;
    }

    @Override
    public int reset(LoginBody body) {
        return 0;
    }

    @Override
    public int logout(String token) {
        return 0;
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
