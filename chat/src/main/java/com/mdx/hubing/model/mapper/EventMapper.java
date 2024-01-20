package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.body.EventBody;
import com.mdx.hubing.model.entity.EventEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface EventMapper {
    int addEvent(@Param("body") EventBody body);

    List<EventEntity> queryEvents(@Param("sid") int sid);

    EventEntity eventDetail(@Param("id") int id);

    int updateEvent(@Param("body") EventBody body);

    int deleteEvent(@Param("id") int id);
}
