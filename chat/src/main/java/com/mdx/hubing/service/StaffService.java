package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.dto.StaffDao;
import com.mdx.hubing.model.entity.StaffEntity;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface StaffService {
    int addStaff(StaffBody body) throws CustomException;
    List<StaffEntity> queryStaffs(int sid) throws CustomException;
    StaffEntity staffDetail(int id) throws CustomException;
    List<StaffDao> queryByUid(int uid) throws CustomException;
    int updateStaff(StaffBody body) throws CustomException;
    int deleteStaff(int id) throws CustomException;
}
