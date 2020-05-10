package com.example.eurekaauth.service;

import com.alibaba.fastjson.JSONObject;
import com.example.eurekaauth.common.CommonResult;
import com.example.eurekaauth.entity.AuthUser;
import com.example.eurekaauth.feign.WxLogin;
import com.example.eurekaauth.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WeChatServiceImpl
 * @Description: TODO
 * @Author: xujin
 * @Date: 2019/12/13 16:29
 * @Version: 1.0
 */
@Service
public class WeChatLoginService {

    @Value("${weChat.appid}")
    private String appid;
    @Value("${weChat.secret}")
    private String secret;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private WxLogin wxLogin;


    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatLoginService.class);


    public CommonResult wxLogin(AuthUser user) throws Exception{
        Object authorization_code = wxLogin.login(appid, secret, user.getCode(), "authorization_code");
        JSONObject sessionInfo = JSONObject.parseObject(authorization_code.toString());
        Assert.notNull(sessionInfo,"code 无效");

        // 获取用户唯一标识符 openid成功

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("userName",user.getOpenId());
        String token = jwtTokenUtil.generateToken(user);
        //redisUtil.hset(token,hashMap);

        return CommonResult.success(sessionInfo,"登陆成功!");
    }

    /**
     * 登录凭证校验
     * @param code
     * @return
     * @throws Exception
     */
//    private String jcode2Session(String code)throws Exception{
//        String sessionInfo = Jcode2SessionUtil.jscode2session(appid,secret,code,"authorization_code");//登录grantType固定
//        LOGGER.info(sessionInfo);
//        return sessionInfo;
//    }
}
