package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.body.SeatBody;
import com.mdx.hubing.model.entity.SeatEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface SeatMapper {
    int addSeat(@Param("body") SeatBody body);

    List<SeatEntity> querySeat(@Param("sid") int sid);

    SeatEntity seatDetail(@Param("id") int id);

    int updateSeat(@Param("body") SeatBody body);

    int deleteSeat(@Param("id") int id);
}
