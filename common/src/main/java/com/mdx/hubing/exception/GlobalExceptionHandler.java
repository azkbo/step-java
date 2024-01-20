package com.mdx.hubing.exception;

import com.mdx.hubing.module.result.ResultBody;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 全局错误处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public ResultBody handleCustomError(CustomException e) {
        System.out.println("===========> CustomException");
        return ResultBody.fail(e);
    }


    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResultBody handleBindError(BindException e) {
        String msg = e.getMessage();
        System.out.println("===========> handleBindError");
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = e.getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                if (fieldError != null) {
                    msg = fieldError.getField() + fieldError.getDefaultMessage();
                }
            }
        } else {
            BindingResult bindingResult = e.getBindingResult();
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                msg = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return ResultBody.paramFail(msg);
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResultBody handleError(RuntimeException e) {
        String msg = e.getMessage();
        System.out.println("===========> handleError");
        System.out.println(e.toString());
//        if (e instanceof MethodNotAllowedException) {
//            System.out.println("===========> MethodNotAllowedException");
//        } else if (e instanceof MethodNotFoundException) {
//            System.out.println("===========> MethodNotFoundException");
//        } else if (e instanceof MethodInvocationException) {
//            System.out.println("===========> MethodInvocationException");
//        } else if (e instanceof HttpRequestMethodNotSupportedException) {
//            System.out.println("===========> HttpRequestMethodNotSupportedException");
//        } else if (e instanceof HttpMessageConversionException) {
//            System.out.println("===========> HttpMessageConversionException");
//        }
        return ResultBody.unknown(msg == null ? ErrorCode.UNKNOWN_ERR.getCEMsg() : msg);
    }

//    @ResponseBody
//    @ExceptionHandler(value = BindException.class)
//    public CommonResult handleBindError(BindException e) {
//        System.out.println("===========> BindException");
//        BindingResult bindingResult = e.getBindingResult();
//        String message = null;
//        if (bindingResult.hasErrors()) {
//            FieldError fieldError = bindingResult.getFieldError();
//            if (fieldError != null) {
//                message = fieldError.getField() + fieldError.getDefaultMessage();
//            }
//        }
//        return CommonResult.paramFail(message);
//    }


}
