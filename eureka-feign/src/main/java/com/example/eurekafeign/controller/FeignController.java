package com.example.eurekafeign.controller;

import com.example.eurekafeign.client.FeignClientFactory;
import com.example.eurekafeign.client.OpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignController
{
    @Autowired
    OpenFeign openFeign;

    @GetMapping("/feign/{one}")
    String feign(@PathVariable("one") String one)
    {
        Map<String,Object> headers = new HashMap<>(10);
        headers.put("Authorization","123");
        headers.put("Accept","application/json");
        //OpenFeign openFeign = FeignClientFactory.create(OpenFeign.class);
        //openFeign.home(one);
        return openFeign.home(one);
    }
}
