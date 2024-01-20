package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.StaffBody;
import com.mdx.hubing.model.entity.FeedbackEntity;
import com.mdx.hubing.model.entity.StaffEntity;
import com.mdx.hubing.model.mapper.FeedbackMapper;
import com.mdx.hubing.model.mapper.StaffMapper;
import com.mdx.hubing.service.StaffService;
import com.mdx.hubing.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public int addFeedback(FeedbackEntity body) throws CustomException {
        int code = 0;
        try {
            code = feedbackMapper.addFeedback(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public List<FeedbackEntity> queryFeedback() throws CustomException {
        List<FeedbackEntity> list = null;
        try {
            list = feedbackMapper.queryList();
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return list;
    }
}
