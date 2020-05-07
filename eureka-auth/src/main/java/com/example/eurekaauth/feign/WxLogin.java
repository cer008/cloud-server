package com.example.eurekaauth.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "wxLogin",url = "https://api.weixin.qq.com")
public interface WxLogin
{
    @GetMapping("/sns/jscode2session")
    @ResponseBody
    String login(@RequestParam("appid")String appid, @RequestParam("secret")String secret, @RequestParam("js_code")String code, @RequestParam("grant_type")String grantType);
}
