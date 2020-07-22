package com.eurekaserver.eurekaserver.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
public class SystemLogAspect {
    //Controller层切点
    @Pointcut("execution (* com.eurekaserver.eurekaserver.rest..*.*(..))")
    public void controllerAspect() {
    }

    //
////    @Before("controllerAspect()")
////    public void doBefore(JoinPoint joinPoint) {
////        System.out.println("==========执行controller前置通知===============");
////
////    }
////
////
////    @After("controllerAspect()")
////    public void doAfter(JoinPoint joinPoint) {
////        System.out.println("==========执行controller后置通知===============");
////    }
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTimeMillis = System.currentTimeMillis();
        log.info("Method Name : [ {} ] ---> args : [ {} ] ---> start", methodName, joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        log.info("Method Name : [{}] ---> exec time millis : {}", methodName, System.currentTimeMillis() - startTimeMillis);
        return proceed;
    }


}
