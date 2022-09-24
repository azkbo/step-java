package com.step.gallery.modules.error;

public interface AppError {
  int getErrCode();
  String getErrMsg();
  AppError setErrMsg(String message);
}
