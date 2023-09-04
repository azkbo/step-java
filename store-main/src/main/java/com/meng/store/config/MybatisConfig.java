package com.meng.store.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc: MyBatis相关配置
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.meng.store.mapper", "com.meng.store.model.mapper","com.meng.store.auth.mapper", "com.meng.store.auth.model.mapper"})
public class MybatisConfig { }
