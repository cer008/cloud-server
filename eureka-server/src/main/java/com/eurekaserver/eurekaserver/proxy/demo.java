package com.eurekaserver.eurekaserver.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @ClassName : demo
 * @Description : 静态代理和动态代理
 * @Author : xj
 * @Date: 2020-09-22 13:56
 */
public class demo {
    public static void main(String[] args) {
        //静态代理要求代理类和被代理类实现同一个接口，代理对象需要持有被代理的目标对象，在代理对象实现接口方法前后添加增强逻辑并调用目标对象方法。
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy(new HelloServicImpl());
        helloServiceProxy.hello();

        //jdk动态代理
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(new HelloServicImpl());
        Object target = jdkDynamicProxy.getTarget();
        HelloService helloService = (HelloService)Proxy.newProxyInstance(jdkDynamicProxy.getClass().getClassLoader(), target.getClass().getInterfaces(), jdkDynamicProxy);
        helloService.hello();

        //CGLIB动态代理
        //1.非接口方式的动态代理
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(cglibDynamicProxy);
        Hello hello = (Hello)enhancer.create();
        hello.hello("123");
        hello.bye();
        //2.接口方式的动态代理
//        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy(new HelloServicImpl());
//        Object target1 = cglibDynamicProxy.getTarget();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setInterfaces(target1.getClass().getInterfaces());
//        enhancer.setCallback(cglibDynamicProxy);
//        HelloService helloService1 = (HelloService)enhancer.create();
//        helloService1.hello();

    }

}


