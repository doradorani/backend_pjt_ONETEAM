package com.oneteam.dormease.user.student;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    /*
     *  회원 가입
     */

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
    
    /*
     * 로그인
     */
    @GetMapping("/loginForm")
    public String loginForm(){
        log.info("loginForm()");

        String nextPage = "/user/student/loginForm";

        return nextPage;

    }

    @PostMapping("/loginConfirm")
    public String loginConfirm(StudentDto studentDto, HttpSession session) {
        log.info("loginConfirm()");

        String nextPage = "/user/student/loginResult";

        StudentDto loginedStudentDto = studentService.loginConfirm(studentDto);

        if(loginedStudentDto != null){
            session.setAttribute("loginedStudentDto", loginedStudentDto);
            session.setMaxInactiveInterval(30*60);
        }

        return nextPage;

    }

    /*
     * 회원 수정
     */
    @GetMapping("/modifyAccountForm")
    public String modifyAccountForm(HttpSession session, Model model){
        log.info("modifyAccountForm()");

        String nextPage = "/user/student/modifyAccountForm";

        StudentDto loginedStudentDto = (StudentDto)session.getAttribute("loginedStudentDto");

        model.addAttribute("loginedStudentDto", loginedStudentDto);

        return nextPage;
    }
    @PostMapping("/modifyAccountConfirm")
    public String modifyAccountConfirm(HttpSession session, Model model){
        log.info("modifyAccountConfirm()");

        String nextPage = "/user/student/modifyAccountResult";

        StudentDto loginedStudentDto = (StudentDto)session.getAttribute("loginedStudentDto");

        model.addAttribute("loginedStudentDto", loginedStudentDto);

        return nextPage;
    }



    /*
     * 로그 아웃
     */
    @GetMapping("/logoutConfirm")
    public String logoutConfirm(HttpSession session){
        log.info("logoutConfirm()");

        String nextPage = "redirect:/";

        session.removeAttribute("loginedStudentDto");

        return nextPage;
    }


}
