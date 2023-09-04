package com.meng.store.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */
public class StoreDetailDto extends StoreListDto implements Serializable {
    public int uid=1; // id
    public String memo; //

    @Override
    public String toString() {
        return "StoreDetailDto{" +
                "memo='" + memo + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                ", env='" + env + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
