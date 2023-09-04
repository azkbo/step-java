# 简介

创建多模块项目

- 1.先创建一个单项目
- 2.删除项目文件
- 3.选中主项目根目录 -> 新建 -> Moudle...
- 4.新建 module选择 maven 项目，输入模块名称
- 5.将模块倒入到主模块
- 6.模块直接相互调用,需在 dependencies 导入对应模块
- 7.全局公用模块可以在主模块中(dependencies 配置)导入
```xml
<!-- 此种方式导入的库，不会主动在模块主动引用，需在dependencies配置 -->
<dependencyManagement>
    <dependencies>
        <!-- 通用模块 -->
        <dependency>
            <groupId>com.meng.store</groupId>
            <artifactId>store-common</artifactId>
            <version>${store-common.version}</version>
        </dependency>
        <!-- account模块 -->
        <dependency>
            <groupId>com.meng.store</groupId>
            <artifactId>store-account</artifactId>
            <version>${store-common.version}</version>
        </dependency>
        <!-- security模块 -->
        <dependency>
            <groupId>com.meng.store</groupId>
            <artifactId>store-security</artifactId>
            <version>${store-common.version}</version>
        </dependency>

        <!-- 数据库驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
        <!-- druid连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.23</version>
        </dependency>
        <!-- 阿里云对象存储 -->
        <dependency>
            <groupId>com.aliyun.oss</groupId>
            <artifactId>aliyun-sdk-oss</artifactId>
            <version>3.16.1</version>
        </dependency>

    </dependencies>
</dependencyManagement>

```