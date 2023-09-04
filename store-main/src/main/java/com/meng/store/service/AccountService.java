package com.meng.store.service;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.LoginBody;
import com.meng.store.model.body.RegisterBody;
import com.meng.store.model.dto.AccountDao;
import com.meng.store.model.entity.AccountEntity;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface AccountService {
    AccountEntity register(RegisterBody body) throws CustomException;
    AccountDao login(LoginBody body);
    int update(String token, RegisterBody body);
    int reset(LoginBody body);
    int logout(String token);
    int delete(String token);
    ArrayList<AccountDao> accountAll();
}
