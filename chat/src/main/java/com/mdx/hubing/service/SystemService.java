package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.entity.FeedbackEntity;
import com.mdx.hubing.model.entity.StaffEntity;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface SystemService {
    int addFeedback(FeedbackEntity body) throws CustomException;
    List<FeedbackEntity> queryFeedback() throws CustomException;
}
