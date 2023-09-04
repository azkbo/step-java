package com.meng.store.model.mapper;

import com.meng.store.exception.CustomException;
import com.meng.store.model.body.AppBody;
import com.meng.store.model.body.ListBody;
import com.meng.store.model.dto.PublishDto;
import com.meng.store.model.dto.StoreDetailDto;
import com.meng.store.model.dto.StoreListDto;
import com.meng.store.module.result.ResultList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface StoreMapper {

    // 获取应用列表
    List<StoreListDto> queryList(@Param("body") ListBody body);

    // 创建应用 {code}, #{app_name}, #{url}, #{env}, #{versions}
    int createApp(@Param("uid") int uid, @Param("code") String code,
                  @Param("name") String name, @Param("url") String url,
                  @Param("version") String version,
                  @Param("tag") String tag, @Param("intro") String intro,
                  @Param("date") String date);

    // 获取应用详情
    StoreDetailDto getDetailById(@Param("id") int id);

    StoreDetailDto getDetailByCode(@Param("code") String code);

    // 更新应用信息
    int updateApp(@Param("id") Integer id, @Param("name") String name, @Param("icon") String icon, @Param("intro") String intro, @Param("version") String version, @Param("modifyTime") String modifyTime);

    int deleteApp(@Param("id") int id);

    int appNumber();

}
