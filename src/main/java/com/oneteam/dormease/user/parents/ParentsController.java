package com.oneteam.dormease.user.parents;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user/parent")
public class ParentsController {

    @GetMapping("/createAccountForm")
    public String createAccountForm(){
        log.info("createAccountForm()");

        String nextPage = "/parents/createAccountForm";

        return nextPage;

    }



    @PostMapping("/loginConfirm")
    public String loginConfirm(){
        log.info("loginConfirm()");

        String nextPage = "";

        return nextPage;
    }
}
