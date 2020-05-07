package com.example.eurekafeign.client;

import feign.HeaderMap;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@Component
@Service
@FeignClient(name = "eureka-client-1")
public interface OpenFeign
{
    //@GetMapping("/hi")
    @RequestLine("GET /hi?one={one}")
    String home(@Param("one") String one);
}
