package com.oneteam.dormease.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class UserController {


    @GetMapping("/user/loginForm")
    public String loginForm(){
        log.info("loginForm()");

        return "/user/loginForm";
    }
}
