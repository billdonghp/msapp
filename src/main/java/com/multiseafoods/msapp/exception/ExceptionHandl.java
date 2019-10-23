package com.multiseafoods.msapp.exception;

import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandl {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandl.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handl(Exception e){
        if (e instanceof CustException){
            CustException custException = (CustException)e;
            return ResultUtil.error(custException.getCode(),custException.getMessage());
        }
        logger.error("异常错误【】",e);
        return ResultUtil.error(-1,"未知错误");
    }
}
