package com.eurekaserver.eurekaserver.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@Primary
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/info",
                "/user/**",
                "/index/front/info",
                "/index/front/orgDataAuth",
                "/index/front/getUserInfo",
                "/index/front/smallAdminInfo",
                "/index/front/orgDataAuthForPush"
        };
        Collections.addAll(list, urls);
        return list;
    }

}
