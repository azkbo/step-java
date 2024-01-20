package com.mdx.hubing.module.result;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class ResultList<T> {
    public int total;
    public int curPage;
    public int pageSize;
    public int pageNum;
    public boolean hasMore;
    public List<T> list;

    public ResultList(List<T> list, int total, int pageSize, int pageNum) {
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.list = list;
        this.curPage = (int) Math.ceil(total*1.0 / pageSize);
        this.hasMore = total > pageNum * pageSize;
    }

    public static <T> ResultList<T> create(List<T> list, int total, int pageSize, int pageNum) {
        return new ResultList<T>(list, total, pageSize, pageNum);
    }
}
