package com.meng.store.service.impl;

import com.meng.store.exception.CustomException;
import com.meng.store.exception.ErrorCode;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.body.PublishBody;
import com.meng.store.model.dao.NewestDao;
import com.meng.store.model.dto.PublishDto;
import com.meng.store.model.dto.StoreDetailDto;
import com.meng.store.model.mapper.PublishMapper;
import com.meng.store.model.mapper.StoreMapper;
import com.meng.store.service.OssService;
import com.meng.store.service.PublishService;
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
public class PublishServiceImpl implements PublishService {
    @Autowired
    PublishMapper publishMapper;
    @Autowired
    StoreMapper storeMapper;
    @Autowired
    OssService ossService;

    @Override
    public long createRecord(String token, PublishBody body) throws CustomException {
        if (body.url == null || body.env == null || (body.aid == null && body.code == null) || body.filePath == null || body.version == null) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }

        int userId = 1;

        String tag = body.filePath.substring(body.filePath.lastIndexOf(".") + 1);
        String code = body.code;
        StoreDetailDto dto;

        if (body.aid != null) {
            dto = storeMapper.getDetailById(body.aid);
        } else {
            code = body.filePath.substring(body.filePath.lastIndexOf("/") + 1, body.filePath.lastIndexOf("."));
            if (code.contains("&")) {
                code = code.substring(code.lastIndexOf("&") + 1);
            }
            dto = storeMapper.getDetailByCode(code);
        }

        if (dto == null) {
            body.aid = storeMapper.createApp(userId, code, body.name, body.url, body.version, tag, body.intro, DateTools.currentDate());
            dto = storeMapper.getDetailByCode(code);
            body.aid = dto.id;
        } else {
            body.aid = dto.id;
            PublishDto pd = getLatest(dto.id, body.env);
            if (pd != null) {
                updatePublish(pd.id, 0);
            }
        }

        long pid = publishMapper.createRecord(userId, body.aid, body.url, body.filePath, body.env, body.intro, body.version, DateTools.currentDate());
        if (pid > 0) {
            storeMapper.updateApp(body.aid, "", "", "", body.version, DateTools.currentDate());
        }
        return pid;
    }

    @Override
    public List<PublishDto> queryRecord(ListBody body) {
        List<PublishDto> list = null;
        if (body.tagId > 0) {
            list = publishMapper.queryRecord(body.tagId, body.keyword);
            if (list != null && list.size() > 0) {
                StoreDetailDto dao = storeMapper.getDetailById(body.tagId);
                if (dao != null) {
                    for (PublishDto item : list) {
                        if (dao.version.equals(item.version)) {
                            item.latest = 1;
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    @Override
    public int deleteRecord(String token, int id) {
        int code = 0;
        if (id > 0) {
            try {
                PublishDto dao = getRecord(id);
                // 删除文件
                ossService.deleteFile(dao.file);
                // 删除记录
                code = publishMapper.deleteRecord(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return code;
    }

    @Override
    public int assignVersion(String token, int id) {
        int code = 0;
        try {
            // 删除当前文件 -> 拷贝此版本文件到最新版本
            PublishDto dao = getRecord(id);
//            ossService.copyFile(dao.file);
            String date = DateTools.currentDate();
            storeMapper.updateApp(dao.aid, null, null, null, dao.version, date);
            code = publishMapper.assignVersion(id, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public PublishDto getLatest(int aid, String env) {
        PublishDto dao = null;
        try {
            dao = publishMapper.getLatest(aid, env);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao;
    }

    @Override
    public NewestDao getNewestVersion(int aid) {
        NewestDao newDao = new NewestDao();
        try {
            List<PublishDto> list = publishMapper.getNewest(aid);
            for (PublishDto dto : list) {
                if (dto.env.equals("prod")) {
                    newDao.setProd(dto);
                } else if (dto.env.equals("test")) {
                    newDao.setTest(dto);
                } else {
                    newDao.setUat(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDao;
    }

    @Override
    public PublishDto getRecord(int id) {
        PublishDto dao = null;
        try {
            dao = publishMapper.getRecord(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao;
    }

    public int updatePublish(int id, int latest) {
        int code = 0;
        try {
            code = publishMapper.updatePublish(id, latest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

}
