package com.meng.store.model.mapper;

import com.meng.store.model.dto.PublishDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface PublishMapper {

    List<PublishDto> queryRecord(@Param("aid") Integer id, @Param("env") String env);

    // 上传应用
    long createRecord(@Param("uid") Integer uid, @Param("aid") Integer aid,
                     @Param("url") String url, @Param("file") String file,
                     @Param("env") String env, @Param("intro") String intro,
                     @Param("version") String version, @Param("date") String date);


    // 删除上传记录
    int deleteRecord(@Param("id") Integer id);

    // 设置当前记录为最新版本
    int assignVersion(@Param("id") Integer id, @Param("modifyTime") String modifyTime);

    // 获取最新上传记录
    PublishDto getLatest(@Param("aid") Integer aid, @Param("env") String env);

    // 获取所有环境最新版本
    List<PublishDto> getNewest(@Param("aid") Integer aid);

    // 获取上传记录
    PublishDto getRecord(@Param("id") Integer id);

    int updatePublish(@Param("id") Integer id, @Param("latest") int latest);
}
