package com.mdx.hubing.module.result;

import com.mdx.hubing.exception.CustomError;
import com.mdx.hubing.exception.ErrorCode;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class ResultBody {
    private int code;
    private String message;
    private Object data;

    public ResultBody(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultBody success(Object data) {
        return new ResultBody(ErrorCode.SUCCESS.getCECode(), ErrorCode.SUCCESS.getCEMsg(), data);
    }

    public static <T> ResultBody list(List<T> list, int total, int pageSize, int pageNum) {
        ResultList data = ResultList.create(list, total, pageSize, pageNum);
        return new ResultBody(ErrorCode.SUCCESS.getCECode(), ErrorCode.SUCCESS.getCEMsg(), data);
    }

    public static ResultBody fail(int code, String message) {
        return new ResultBody(code, message, null);
    }

    public static ResultBody fail(CustomError error) {
        return new ResultBody(error.getCECode(), error.getCEMsg(), null);
    }

    public static ResultBody unknown(String message) {
        return new ResultBody(ErrorCode.UNKNOWN_ERR.getCECode(), message, null);
    }

    public static ResultBody paramFail(String message) {
        return new ResultBody(ErrorCode.PARAM_VALIDATE_FAIL.getCECode(), message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message +
                ", data=" + data.toString() + '}';
    }
}
