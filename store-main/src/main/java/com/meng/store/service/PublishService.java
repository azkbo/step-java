package com.meng.store.service;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.body.PublishBody;
import com.meng.store.model.dao.NewestDao;
import com.meng.store.model.dto.PublishDto;
import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface PublishService {
    // 上传应用
    long createRecord(String token, PublishBody body) throws CustomException;

    // 查询应用记录
    List<PublishDto> queryRecord(ListBody body) throws CustomException;

    // 删除上传记录
    int deleteRecord(String token, int id);

    // 设置当前记录为最新版本
    int assignVersion(String token, int id);

    // 获取最新上传记录
    PublishDto getLatest(int aid, String env);

    // 获取所有环境最新版本
    NewestDao getNewestVersion(int aid);

    // 上传记录信息
    PublishDto getRecord(int id);
}
