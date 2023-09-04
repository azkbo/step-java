package com.meng.store.model.dto;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class PublishDto {
    public int id;
    public int aid=1;
    public int uid=1;
    public int latest=0;
    public String url;
    public String file;

    public String env;
    public String version; // 'xx.xx.xx'
    public String intro; //
    public String createTime;
    public String modifyTime;

    @Override
    public String toString() {
        return "PublishDto{" +
                "id=" + id +
                ", aid=" + aid +
                ", uid=" + uid +
                ", latest=" + latest +
                ", url='" + url + '\'' +
                ", file='" + file + '\'' +
                ", env='" + env + '\'' +
                ", version='" + version + '\'' +
                ", intro='" + intro + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
