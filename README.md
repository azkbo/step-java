# 简介
一个简单的应用管理及发布平台。

### 功能介绍

- 可以发布 Android App。
- 可以发布 H5.zip 包。
- 鼠标放置到应用图标出现文件的下载二维码，点击右上角复制按钮可以复制连接
- 点击应用图标可以查看应用详情，包含发布历史列表(分环境prod,test,dev)，
- 可以删除历史版本，可以设置历史版本为最新，可以上传新版本

- POJO: 全称为：Plain Ordinary Java Object，即简单普通的java对象。一般用在数据层映射到数据库表的类，类的属性与表字段一一对应。

- PO: 全称为：Persistant Object，即持久化对象。可以理解为数据库中的一条数据即一个BO对象，也可以理解为POJO经过持久化后的对象。

- DTO: 全称为：Data Transfer Object，即数据传输对象。一般用于向数据层外围提供仅需的数据，如查询一个表有50个字段，界面或服务只需要用到其中的某些字段，DTO就包装出去的对象。可用于隐藏数据层字段定义，也可以提高系统性能，减少不必要字段的传输损耗。

- DAO: 全称为：Data Access Object，即数据访问对象。就是一般所说的DAO层，用于连接数据库与外层之间的桥梁，并且持久化数据层对象。

- BO: 全称为：Business Object，即业务对象。一般用在业务层，当业务比较复杂，用到比较多的业务对象时，可用BO类组合封装所有的对象一并传递。

- VO: 全称为：Value Object，有的也称为View Object，即值对象或页面对象。一般用于web层向view层封装并提供需要展现的数据。

  - common      -共通层
  - service     -业务逻辑层
  - controller  -控制器层
  - dao         -数据持久层
  - dto         -数据传输对象层
  - entity      -实体层