package com.meng.store.service;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.AppBody;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.dto.AccountDao;
import com.meng.store.model.dto.StoreDetailDto;
import com.meng.store.model.dto.StoreListDto;
import com.meng.store.module.result.ResultList;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface StoreService {
    // 创建应用
    AppBody createApp(AppBody body, String token) throws CustomException;

    // 获取应用列表
    ResultList<StoreListDto> queryList(ListBody body) throws CustomException;

    // 获取应用详情
    StoreDetailDto getAppDetail(int id, String code) throws CustomException;

    // 更新应用信息
    int updateApp(AppBody body, String token) throws CustomException;

    // 删除应用
    int deleteApp(int id, String token) throws CustomException;

    // 应用总数
    int appNumber();

    // 添加上传记录
    int publishPackage(AppBody body, String token);

}
