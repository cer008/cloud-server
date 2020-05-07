package com.example.eurekaauth.common;

/**
 * @ClassName: ResultCode
 * @Description: TODO 枚举了一些常用API操作码
 * @Author: xujin
 * @Date: 2019/11/18 16:53
 * @Version: 1.0
 */
public enum ResultCode implements IErrorCode {
    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"),
    LOGIN_FAILED("-10001","登陆失败"),
    VALIDATE_FAILED("404", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限");
    private String code;
    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
