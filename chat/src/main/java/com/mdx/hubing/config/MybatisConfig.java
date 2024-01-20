package com.mdx.hubing.config;

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
@MapperScan({"com.mdx.hubing.mapper", "com.mdx.hubing.model.mapper"})
public class MybatisConfig { }
