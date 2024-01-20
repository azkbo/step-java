package com.mdx.hubing.exception;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class CustomException extends Exception implements CustomError  {
    private static final long serialVersionUID = 9736L;

    private CustomError error;

    public CustomException(CustomError appError) {
        this.error = appError;
    }

    public static CustomException create(CustomError error) {
        return new CustomException(error);
    }

    public CustomException(CustomError error, String msg) {
        this.error = error;
        this.error.setCEMsg(msg);
    }

    @Override
    public int getCECode() {
        return error.getCECode();
    }

    @Override
    public String getCEMsg() {
        return error.getCEMsg();
    }

    @Override
    public CustomError setCEMsg(String message) {
        return error.setCEMsg(message);
    }
}
