package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.EventBody;
import com.mdx.hubing.model.entity.EventEntity;
import com.mdx.hubing.model.mapper.EventMapper;
import com.mdx.hubing.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventMapper eventMapper;

    @Override
    public int addEvent(EventBody body) throws CustomException {
        int code = 0;
        try {
            code = eventMapper.addEvent(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public List<EventEntity> queryEvents(int sid) throws CustomException {
        List<EventEntity> list = null;
        try {
            list = eventMapper.queryEvents(sid);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return list;
    }

    @Override
    public EventEntity eventDetail(int id) throws CustomException {
        EventEntity event = null;
        try {
            event = eventMapper.eventDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return event;
    }

    @Override
    public int updateEvent(EventBody body) throws CustomException {
        int code = 0;
        try {
            code = eventMapper.updateEvent(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public int deleteEvent(int id) throws CustomException {
        int code = 0;
        try {
            code = eventMapper.deleteEvent(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }
}
