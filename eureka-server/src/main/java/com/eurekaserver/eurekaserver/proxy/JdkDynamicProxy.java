package com.eurekaserver.eurekaserver.proxy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName : JdkDynamicProxy
 * @Description : jdk动态代理,通过反射实现
 * @Author : xj
 * @Date: 2020-09-22 14:16
 */
@Data
public class JdkDynamicProxy implements InvocationHandler {
    private Object target;
    public JdkDynamicProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before say hello");
        System.out.println("name :"+method.getName() + ",args :"+args);
        Object invoke = method.invoke(target, args);
        System.out.println("after say hello");
        return invoke;
    }
}
