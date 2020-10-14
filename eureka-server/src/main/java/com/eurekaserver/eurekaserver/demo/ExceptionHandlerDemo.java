package com.eurekaserver.eurekaserver.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : ExceptionHandlerDemo
 * @Description :
 * @Author : xj
 * @Date: 2020-10-13 13:10
 */
@RestController
@RequestMapping(value = "ExceptionHandlerDemo")
public class ExceptionHandlerDemo {
    class User{
        String name;
        public String getName() {
            return name;
        }
    }
    /**
    * @Param []
    * @description  测试全局异常处理
    * @author xj
    * @date 2020/10/14 11:34
    * @return java.lang.Object
    * @throws
    */
    @RequestMapping(value = "/test/null",method = RequestMethod.GET)
    public Object testnull(){
        User user = null;
        user.getName();
        return user;
    }
    
    /**
    * @Param []
    * @description   测试全局response处理
    * @author xj 
    * @date 2020/10/14 11:33 
    * @return java.util.Map 
    * @throws  
    */
    @RequestMapping(value = "/test/response",method = RequestMethod.GET)
    @ResponseBody
    public Map response(){
        Map map = new HashMap();
        map.put("k","v");
        return map;
    }
}
