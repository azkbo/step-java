package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.SeatBody;
import com.mdx.hubing.model.entity.SeatEntity;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface SeatService {
    int addSeat(SeatBody body) throws CustomException;
    List<SeatEntity> querySeats(int sid) throws CustomException;
    SeatEntity seatDetail(int id) throws CustomException;
    int updateSeat(SeatBody body) throws CustomException;
    int deleteSeat(int id) throws CustomException;
}
