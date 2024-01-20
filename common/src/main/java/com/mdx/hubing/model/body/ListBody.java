package com.mdx.hubing.model.body;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */
public class ListBody {
    public int sort; // 排序
    public int tagId; // 搜索关键字
    public int pageNum;
    public int pageSize;
    public String keyword; // 搜索关键字

    @Override
    public String toString() {
        return "ListBody{" +
                "sort=" + sort +
                ", tagId=" + tagId +
                ", keyword='" + keyword + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
