package com.example.eurekaauth.common;

/**
 * @ClassName: WeChatUrl
 * @Description: TODO
 * @Author: xujin
 * @Date: 2019/12/13 11:19
 * @Version: 1.0
 */
public enum WeChatUrl
{

    JS_CODE_2_SESSION("https://api.weixin.qq.com/sns/jscode2session")
    ,GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token")
    ,SEND_TEMPLATE_MESSAGE("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send")
    ;

    private String url;

    WeChatUrl() {
    }

    WeChatUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public WeChatUrl setUrl(String url) {
        this.url = url;
        return this;
    }
}