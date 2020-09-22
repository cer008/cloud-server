package com.eurekaserver.eurekaserver.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName : JdkDynamicProxyFactory
 * @Description :
 * @Author : xj
 * @Date: 2020-09-22 14:39
 */
public class JdkDynamicProxyFactory {
    private JdkDynamicProxy jdkDynamicProxy;

    public JdkDynamicProxyFactory(JdkDynamicProxy JdkDynamicProxy) {
        this.jdkDynamicProxy = JdkDynamicProxy;
    }

    public Object getProxy() {
        Object target = jdkDynamicProxy.getTarget();
        return Proxy.newProxyInstance(jdkDynamicProxy.getClass().getClassLoader(), target.getClass().getInterfaces(), jdkDynamicProxy);
    }
}
