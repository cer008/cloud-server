package com.eurekaserver.eurekaserver.proxy;

/**
 * @ClassName : HelloServicImpl
 * @Description :
 * @Author : xj
 * @Date: 2020-09-22 13:58
 */
public class HelloServicImpl implements HelloService {


    @Override
    public void hello() {
        System.out.println("hello");
    }
}
