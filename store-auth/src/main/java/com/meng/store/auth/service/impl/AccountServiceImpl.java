package com.meng.store.auth.service.impl;

import com.meng.store.auth.model.body.LoginBody;
import com.meng.store.auth.model.mapper.AccountMapper;
import com.meng.store.auth.model.body.RegisterBody;
import com.meng.store.auth.model.dto.AccountDao;
import com.meng.store.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AccountDao register(RegisterBody body) {

        return accountMapper.register(body);
    }

    @Override
    public AccountDao login(LoginBody body) {
        return null;
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
}
