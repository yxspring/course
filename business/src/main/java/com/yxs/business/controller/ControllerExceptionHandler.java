package com.yxs.business.controller;

import com.yxs.server.exception.ValidatorException;
import com.yxs.server.util.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger Log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public ResponseDto validatorExceptionHandler(ValidatorException e){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setSuccess(false);
        Log.warn(e.getMessage());
        responseDto.setMessage("请求参数异常！");
        return responseDto;
    }
}
