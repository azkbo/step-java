package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.EventBody;
import com.mdx.hubing.model.entity.EventEntity;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface EventService {
    int addEvent(EventBody body) throws CustomException;
    List<EventEntity> queryEvents(int sid) throws CustomException;
    EventEntity eventDetail(int id) throws CustomException;
    int updateEvent(EventBody body) throws CustomException;
    int deleteEvent(int id) throws CustomException;
}
