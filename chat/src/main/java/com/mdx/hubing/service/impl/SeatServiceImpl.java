package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.SeatBody;
import com.mdx.hubing.model.entity.SeatEntity;
import com.mdx.hubing.model.mapper.SeatMapper;
import com.mdx.hubing.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatMapper seatMapper;

    @Override
    public int addSeat(SeatBody body) throws CustomException {
        int code = 0;
        try {
            System.out.println(body);
            code = seatMapper.addSeat(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public List<SeatEntity> querySeats(int sid) throws CustomException {
        List<SeatEntity> list = null;
        try {
            list = seatMapper.querySeat(sid);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return list;
    }

    @Override
    public SeatEntity seatDetail(int id) throws CustomException {
        SeatEntity seat = null;
        try {
            seat = seatMapper.seatDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return seat;
    }

    @Override
    public int updateSeat(SeatBody body) throws CustomException {
        int code = 0;
        try {
            System.out.println(body);
            code = seatMapper.updateSeat(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public int deleteSeat(int id) throws CustomException {
        int code = 0;
        try {
            code = seatMapper.deleteSeat(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }
}
