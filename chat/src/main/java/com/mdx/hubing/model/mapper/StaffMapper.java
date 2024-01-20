package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.dto.StaffDao;
import com.mdx.hubing.model.entity.StaffEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface StaffMapper {
    int addStaff(@Param("body") StaffBody body);

    List<StaffEntity> queryStaff(@Param("sid") int sid);

    StaffEntity staffDetail(@Param("id") int id);

    List<StaffDao> queryByUid(@Param("uid") int uid);

    int updateStaff(@Param("body") StaffBody body);

    int deleteStaff(@Param("id") int id);

}
