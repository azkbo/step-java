package com.mdx.hubing.model.body;

/**
 * Author: Meng
 * Date: 2023-11-12
 * Desc:
 */
public class SeatBody {
    public int id;
    public int sid; //
    public Integer num;
    public int used = 0;
    public int status = 0; // 0已收，1代收，2收桌
    public String intro = ""; //
    public String position=""; //

    @Override
    public String toString() {
        return "SeatBody{" +
                "id=" + id +
                ", sid=" + sid +
                ", num=" + num +
                ", used=" + used +
                ", status=" + status +
                ", intro='" + intro + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
