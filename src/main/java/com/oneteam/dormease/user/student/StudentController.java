package com.oneteam.dormease.user.student;

import com.oneteam.dormease.user.student.leavePass.LeavePassDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/user/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    /*
     *  회원 가입
     */

    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        log.info("createAccountForm()");

        String nextPage = "user/student/createAccountForm";

        return nextPage;

    }

    @PostMapping("/createAccountConfirm")
    public String createAccountConfirm(StudentDto studentDto, Model model) {
        log.info("createAccountConfirm()");
        log.info("school_no{}", studentDto.getSchool_no());

        String nextPage = "user/student/createAccountResult";

        int result = studentService.createAccountConfirm(studentDto);

        model.addAttribute("result", result);

        return nextPage;

    }
    
    /*
     * 로그인
     */

    @PostMapping("/loginConfirm")
    @ResponseBody
    public Object loginConfirm(StudentDto studentDto, HttpSession session) {
        log.info("loginConfirm()");

        StudentDto loginedStudentDto = studentService.loginConfirm(studentDto);
        Map<String, Object> map = new HashMap<>();

        if(loginedStudentDto != null){
            session.setAttribute("loginedStudentDto", loginedStudentDto);
            session.setMaxInactiveInterval(30*60);

            map.put("result", true);
        } else {
            map.put("result", false);
        }

        return map;

    }

    /*
     * 회원 수정
     */
    @GetMapping("/modifyAccountForm")
    public String modifyAccountForm(HttpSession session, Model model){
        log.info("modifyAccountForm()");

        String nextPage = "user/student/modifyAccountForm";

        StudentDto loginedStudentDto = (StudentDto)session.getAttribute("loginedStudentDto");

        model.addAttribute("loginedStudentDto", loginedStudentDto);

        return nextPage;
    }

    @PostMapping("/modifyAccountConfirm")
    public String modifyAccountConfirm(HttpSession session, Model model){
        log.info("modifyAccountConfirm()");

        String nextPage = "user/student/modifyAccountResult";

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

    /*
     * 회원 탈퇴
     */
    @GetMapping("/deleteConfirm")
    @ResponseBody
    public Object deleteConfirm(@RequestParam int no){
        log.info("deleteConfirm()");

        int result = studentService.deleteConfirm(no);

        Map<String, Object> map = new HashMap<>();
        map.put("result", result);

        return map;
    }
    
    /*
     * 외박 신청 폼
     */
    @GetMapping("/leaveOutForm")
    public String leaveOutForm() {
        log.info("leaveOutForm()");

        String nextPage = "user/student/leaveOutForm";

        return nextPage;
    }
    /*
     * 외박 신청 컨펌
     */
    @PostMapping("/leaveOutConfirm")
    public String leaveOutConfirm(LeavePassDto leavePassDto) {
        log.info("leaveOutConfirm()");

        String nextPage = "/user/student/leaveOutList";
        nextPage = "Home";

        int result = studentService.leaveOutConfirm(leavePassDto);
        if(result <= 0){
            nextPage = "redirect:/user/student/leaveOutForm";
        }

        return nextPage;
    }


}
