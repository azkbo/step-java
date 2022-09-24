package com.step.robot.controller;

import javax.servlet.http.HttpServletRequest;

import com.step.robot.config.error.AppError;
import com.step.robot.config.error.EnumError;
import com.step.robot.entity.result.DataResult;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 */
public class BaseController {

  public final String FORM = "application/x-www-form-urlencoded";
  public final String JSON = "application/json;charset=utf-8";

  @ResponseBody
  @ExceptionHandler
  @ResponseStatus(HttpStatus.OK)
  public DataResult exceptionHandle(HttpServletRequest request, Exception ex) {
    int code = EnumError.UNKOWN_ERROR.getErrCode();
    String msg = EnumError.UNKOWN_ERROR.getErrMsg();
    if(ex instanceof AppError) {
      AppError aex = (AppError) ex;
      code = aex.getErrCode();
      msg = aex.getErrMsg();
    }
    return DataResult.create(code, msg);
  }
}