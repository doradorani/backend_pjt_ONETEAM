package com.oneteam.dormease.user.student;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Controller
@RequestMapping("/user/student")
public class StudentController {

    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        log.info("createAccountForm()");

        String nextPage = "/";

        return nextPage;

    }

    @PostMapping("/createAccountConfirm")
    public String createAccountConfirm(StudentDto studentDto) {
        log.info("createAccountConfirm()");

        String nextPage = "";

        return nextPage;

    }
}
