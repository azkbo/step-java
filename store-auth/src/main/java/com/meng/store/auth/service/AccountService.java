package com.meng.store.auth.service;

import com.meng.store.auth.model.body.LoginBody;
import com.meng.store.auth.model.body.RegisterBody;
import com.meng.store.auth.model.dto.AccountDao;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface AccountService {
    AccountDao register(RegisterBody body);
    AccountDao login(LoginBody body);
    int update(String token, RegisterBody body);
    int reset(LoginBody body);
    int logout(String token);
    int delete(String token);
}
