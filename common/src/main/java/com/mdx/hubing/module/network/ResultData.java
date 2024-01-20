package com.mdx.hubing.module.network;

/**
 * Author: Meng
 * Date: 2023-11-11
 * Desc:
 */
public class ResultData<T> {
    public int code = -1;
    public String message = "";
    public T data;

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
