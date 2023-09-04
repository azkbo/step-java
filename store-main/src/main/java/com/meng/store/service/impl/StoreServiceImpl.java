package com.meng.store.service.impl;

import com.meng.store.exception.CustomException;
import com.meng.store.exception.ErrorCode;
import com.meng.store.model.body.AppBody;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.dto.StoreDetailDto;
import com.meng.store.model.dto.StoreListDto;
import com.meng.store.model.mapper.StoreMapper;
import com.meng.store.module.result.ResultList;
import com.meng.store.service.StoreService;
import com.meng.store.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;

    @Override
    public AppBody createApp(AppBody body, String token) throws CustomException {
        if (body.name == null || body.url == null || body.code == null || body.version == null) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        int userId = 0;
        StoreDetailDto dto = storeMapper.getDetailByCode(body.code);
        if (dto != null) {
            throw CustomException.create(ErrorCode.APP_EXIST);
        }

        String tag = body.url.substring(body.url.lastIndexOf(".") + 1);
        int id = storeMapper.createApp(userId, body.code, body.name, body.url, body.version, tag, body.intro, DateTools.currentDate());
        body.id = id;
        return body;
    }

    @Override
    public ResultList<StoreListDto> queryList(ListBody body) {
        List<StoreListDto> list = storeMapper.queryList(body);
        return ResultList.create(list, list.size(), 10, 1);
    }

    @Override
    public StoreDetailDto getAppDetail(int id, String code) throws CustomException {
        StoreDetailDto entity;
        if (code != null && code.length() > 0) {
            entity = storeMapper.getDetailByCode(code);
        }else {
            entity = storeMapper.getDetailById(id);
        }
        return entity;
    }

    @Override
    public int updateApp(AppBody body, String token) throws CustomException {
        if (body.id < 1) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        return storeMapper.updateApp(body.id, body.name, body.icon, body.intro, body.version, DateTools.currentDate());
    }

    @Override
    public int deleteApp(int id, String token) throws CustomException {
        int num = storeMapper.deleteApp(id);
        if (num < 1) {
            throw CustomException.create(ErrorCode.FAIL);
        }
        return num;
    }

    @Override
    public int appNumber() {
        return storeMapper.appNumber();
    }

    @Override
    public int publishPackage(AppBody body, String token) {
        return 0;
    }

}
