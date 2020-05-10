package com.example.eurekaauth.rest;

import com.example.eurekaauth.common.CommonResult;
import com.example.eurekaauth.entity.AuthUser;
import com.example.eurekaauth.service.impl.AuthUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/user")
public class AuthUserController
{
    @Autowired
    private AuthUserServiceImpl authUserServiceImpl;

    @PostMapping("/add")
    @ResponseBody
    public CommonResult add(@RequestBody AuthUser authUser)
    {
        return authUserServiceImpl.add(authUser);
    }
}
