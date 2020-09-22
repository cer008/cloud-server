package com.eurekaserver.eurekaserver.proxy;

import lombok.Data;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName : CglibProxy
 * @Description :
 * @Author : xj
 * @Date: 2020-09-22 14:53
 */
@Data
public class CglibDynamicProxy implements MethodInterceptor {
//    private Object target;
//    public CglibDynamicProxy(Object target){
//        this.target = target;
//    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before say hello");
        Object object = methodProxy.invokeSuper(o, objects);
        //Object object1 = methodProxy.invoke(o, objects);
        System.out.println("after say hello");
        return object;
    }
}
