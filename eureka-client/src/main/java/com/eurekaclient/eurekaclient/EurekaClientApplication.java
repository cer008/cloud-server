package com.eurekaclient.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${spring.application.name}")
    private String str;
    @GetMapping(value = "/test")
    Object test()
    {
        return "这是返回数据" + str;
    }

    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String home(@RequestParam String one) {
        System.out.println("hi" + System.currentTimeMillis());
        System.out.println("执行 hi -------------------------时间"+System.currentTimeMillis()+"-------------------------------- ");
        return "hi "+one+",i am from port:" +port;
    }

}
