package com.mdx.hubing.exception;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface CustomError {
    int getCECode();
    String getCEMsg();
    CustomError setCEMsg(String message);
}
