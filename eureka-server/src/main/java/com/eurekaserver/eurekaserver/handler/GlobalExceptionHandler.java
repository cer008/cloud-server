package com.eurekaserver.eurekaserver.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName : ExceptionHandler
 * @Description : 全局异常初处理中心
 * @Author : xj
 * @Date: 2020-10-13 11:09
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerException(NullPointerException e){
        e.printStackTrace();
        return "空指针异常123123123";
    }
}
