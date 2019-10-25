package com.multiseafoods.msapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.multiseafoods.msapp.controller.CustomerController.*(..))")
    public void log(){}

    @After("log()")
    public void doAfter(){
        logger.info("logger.info(after)");

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        logger.info(request.getMethod() +"---"+request.getHeader("authorization"));
    }

    @Before("log()")
    public void doBefor(){
        logger.info("logger.info(before)");
    }

}
