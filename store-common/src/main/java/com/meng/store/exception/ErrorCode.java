package com.meng.store.exception;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public enum ErrorCode implements CustomError {

    SUCCESS(0, "成功"),
    FAIL(10010, "操作失败"),
    UNKNOWN_ERR(10101, "未知错误"),
    PARAM_EMPTY(10102, "参数不能为空"),
    PARAM_VALIDATE_FAIL(10011, "参数检验失败"),
    UNAUTHORIZED(10012, "未登录或登录已过期"),
    APP_EXIST(10012, "应用已存在"),
    ACCOUNT_EXIST(10101, "账号已存在"),
    FORBIDDEN(10100, "没有相关权限");;

    private final int code;
    private String msg;

    private ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public int getCECode() {
        return code;
    }

    @Override
    public String getCEMsg() {
        return msg;
    }

    @Override
    public CustomError setCEMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
