package com.example.eurekafeign.client;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Configuration;

public abstract class FeignClientFactory {
    public static <T> T create(Class<T> clazz) {
        return Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL) // 输出日志到控制台
                .retryer(Retryer.NEVER_RETRY) // 关闭重试
                .decode404() // 把404也解码 -> 这样就不会以一场形式抛出，中断程序喽，方便我测试嘛
                .target(clazz, "http://localhost:8003");
    }
}
