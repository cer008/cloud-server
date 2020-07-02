package com.eurekaserver.eurekaserver.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class index {
    @RequestMapping("/index")
    public String  index (){
        return "lcj";
    }
}
