package com.meng.store.auth.model.mapper;

import com.meng.store.auth.model.body.LoginBody;
import com.meng.store.auth.model.body.RegisterBody;
import com.meng.store.auth.model.dto.AccountDao;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */
public interface AccountMapper {
    AccountDao register(@Param("user") RegisterBody user);
    AccountDao login(@Param("body") LoginBody body);
    int update(@Param("body") RegisterBody body);
    int reset(@Param("body") LoginBody body);
    int logout(int id);
    int delete(int id);
}
