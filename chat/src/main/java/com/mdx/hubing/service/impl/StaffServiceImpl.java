package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.dto.StaffDao;
import com.mdx.hubing.model.entity.StaffEntity;
import com.mdx.hubing.model.mapper.StaffMapper;
import com.mdx.hubing.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;

    @Override
    public int addStaff(StaffBody body) throws CustomException {
        int code = 0;
        if(body.uid == null || body.sid == null) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        try {
            code = staffMapper.addStaff(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public List<StaffEntity> queryStaffs(int sid) throws CustomException {
        List<StaffEntity> list = null;
        try {
            list = staffMapper.queryStaff(sid);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return list;
    }

    @Override
    public StaffEntity staffDetail(int id) throws CustomException {
        StaffEntity staff = null;
        try {
            staff = staffMapper.staffDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return staff;
    }

    @Override
    public List<StaffDao> queryByUid(int uid) throws CustomException {
        if (uid < 1) {
            throw CustomException.create(ErrorCode.PARAM_FAIL);
        }
        List<StaffDao> dao = staffMapper.queryByUid(uid);
        return dao;
    }

    @Override
    public int updateStaff(StaffBody body) throws CustomException {
        int code = 0;
        try {
            code = staffMapper.updateStaff(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public int deleteStaff(int id) throws CustomException {
        int code = 0;
        try {
            code = staffMapper.deleteStaff(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }
}
