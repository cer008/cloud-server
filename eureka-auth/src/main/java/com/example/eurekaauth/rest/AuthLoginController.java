package com.example.eurekaauth.rest;

import com.example.eurekaauth.common.CommonResult;
import com.example.eurekaauth.service.WeChatLoginService;
import com.example.eurekaauth.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "app/auth")
public class AuthLoginController
{
    @Autowired
    private WeChatLoginService weChatLoginService;

    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody User user) throws Exception
    {
        return weChatLoginService.wxLogin(user);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() throws Exception
    {
        return "success";
    }

}
