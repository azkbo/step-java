package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.entity.FeedbackEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface FeedbackMapper {
    int addFeedback(@Param("body") FeedbackEntity body);
    List<FeedbackEntity> queryList();
}
