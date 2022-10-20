package com.step.gallery.entity.result;

import java.util.List;

import com.step.gallery.modules.error.AppError;
import com.step.gallery.modules.error.EnumError;

public class DataResult {
  private int code;
  private String msg;
  private Object data;


  public DataResult(int code, String message, Object data) {
    this.code = code;
    this.msg = message;
    this.data = data;
  }

  public static DataResult succee(String message) {

    return create(EnumError.OK.getErrCode(), message, message);
  }

  public static DataResult succee(Object data) {

    return create(EnumError.OK.getErrCode(), EnumError.OK.getErrMsg(), data);
  }

  public static DataResult list(List<Object> list, int total, int pageSize, int pageNum) {
    ListData data = ListData.create(list, total, pageSize, pageNum);
    return create(EnumError.OK.getErrCode(), EnumError.OK.getErrMsg(), data);
  }

  // changj
  public static DataResult create(int code, String message, Object data) {
    return new DataResult(code, message, data);
  }

  public static DataResult create(int code, String message) {

    return create(code, message, null);
  }

  public static DataResult create(AppError error) {

    return create(error.getErrCode(), error.getErrMsg(), null);
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return msg;
  }

  public Object getData() {
    return data;
  }
}
