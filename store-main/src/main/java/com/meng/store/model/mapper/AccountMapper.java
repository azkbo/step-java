package com.meng.store.model.mapper;

import com.meng.store.model.body.*;
import com.meng.store.model.dto.AccountDao;
import com.meng.store.model.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */
public interface AccountMapper {
    int register(@Param("user") AccountEntity account);

    AccountDao login(@Param("body") LoginBody body);

    //    int[] query(@Param("body") LoginBody body);
    int query(@Param("body") LoginBody body);

    int update(@Param("user") RegisterBody body);

    int reset(@Param("token") String token);

    int logout(int id);

    int delete(int id);

    ArrayList<AccountDao> accountAll();
}
