package com.example.book_management_spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class BookAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning("execution(* com.example.book_management_spring.controller.*.*(..))")
//    @AfterReturning("within(com..*)")
    public void logAfterMethodReturn(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
//        System.err.println("action :" +nameMethod + " ---args : "+args);
        logger.error("Ten phuong thuc : "+nameMethod);
        logger.error("Tham so : "+args);
    }
}
