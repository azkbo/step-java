package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.body.*;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.entity.AccountEntity;
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

    AccountDao wxLogin(@Param("body") LoginBody body);

    int query(@Param("body") LoginBody body);

    AccountDao queryByCode(@Param("code") String code);

    int updateAccount(@Param("body") LoginBody body);

    int reset(@Param("token") String token);

    int logout(int id);

    int accountNum();

    ArrayList<AccountDao> accountAll();
}
