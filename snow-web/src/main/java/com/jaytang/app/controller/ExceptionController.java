package com.jaytang.app.controller;

import com.jaytang.config.model.SnowException;
import com.jaytang.model.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SnowException.class)
    public ResultData handleShiroException(Exception ex) {
        return ResultData.fail().msg(ex.getCause().getMessage());
    }

}
