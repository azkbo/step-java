package com.mdx.hubing.model.body;

/**
 * Author: Meng
 * Date: 2023-11-12
 * Desc:
 */
public class EventBody {
    public int id;
    public int sid; //
    public int tag;
    public String value; //
    public String url; //
    public String intro; //

    @Override
    public String toString() {
        return "EventBody{" +
                "id=" + id +
                ", sid=" + sid +
                ", tag=" + tag +
                ", value='" + value + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
