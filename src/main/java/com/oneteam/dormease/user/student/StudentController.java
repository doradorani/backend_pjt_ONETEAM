package com.oneteam.dormease.user.student;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Controller
@RequestMapping("/user/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        log.info("createAccountForm()");

        String nextPage = "/user/student/createAccountForm";

        return nextPage;

    }

    @PostMapping("/createAccountConfirm")
    public String createAccountConfirm(StudentDto studentDto, Model model) {
        log.info("createAccountConfirm()");

        String nextPage = "/user/student/createAccountResult";

        int result = studentService.createAccountConfirm(studentDto);

        model.addAttribute("result", result);

        return nextPage;

    }
}
