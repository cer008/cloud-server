package com.eurekaserver.eurekaserver.proxy;

/**
 * @ClassName : HelloServiceProxy
 * @Description :
 * @Author : xj
 * @Date: 2020-09-22 13:58
 */
public class HelloServiceProxy implements HelloService {
    private HelloServicImpl helloServicImpl;

    public HelloServiceProxy(HelloServicImpl helloServicImpl) {
        this.helloServicImpl = helloServicImpl;
    }

    @Override
    public void hello() {
        System.out.println("before say hello");
        helloServicImpl.hello();
        System.out.println("after say hello");
    }
}
