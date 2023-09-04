package com.oneteam.dormease.user.parents;

import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.processor.SpringObjectTagProcessor;

import javax.swing.text.html.parser.Parser;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/user/parents")
public class ParentsController {
    private final ParentsService parentsService;
    public ParentsController (ParentsService parentsService) {
        this.parentsService = parentsService;
    }

    /*
     *  회원 가입
     */

    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        log.info("createAccountForm()");

        String nextPage = "user/parents/createAccountForm";

        return nextPage;

    }
    @GetMapping("/searchStudents")
    @ResponseBody
    public Object searchStudents(StudentDto studentDto) {
        log.info("searchStudents()");

        return parentsService.searchStudents(studentDto);

    }

    @PostMapping("/createAccountConfirm")
    public String createAccountConfirm(ParentsDto parentsDto, Model model) {
        log.info("createAccountConfirm()");

        String nextPage = "user/parents/createAccountResult";

        int result = parentsService.createAccountConfirm(parentsDto);

        model.addAttribute("result", result);

        return nextPage;

    }

    /*
     * 로그인
     */
    @PostMapping("/loginConfirm")
    @ResponseBody
    public Object loginConfirm(ParentsDto parentsDto, HttpSession session) {
        log.info("loginConfirm()");

        ParentsDto loginedParentsDto = parentsService.loginConfirm(parentsDto);

        Map<String, Object> map = new HashMap<>();

        if(loginedParentsDto != null){
            session.setAttribute("loginedParentsDto", loginedParentsDto);
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

        String nextPage = "/user/parents/modifyAccountForm";

        ParentsDto loginedParentsDto = (ParentsDto)session.getAttribute("loginedparentsDto");

        model.addAttribute("loginedparentsDto", loginedParentsDto);

        return nextPage;
    }

    @PostMapping("/modifyAccountConfirm")
    public String modifyAccountConfirm(HttpSession session, Model model){
        log.info("modifyAccountConfirm()");

        String nextPage = "/user/parents/modifyAccountResult";

        ParentsDto loginedParentsDto = (ParentsDto)session.getAttribute("loginedparentsDto");

        model.addAttribute("loginedparentsDto", loginedParentsDto);

        return nextPage;
    }



    /*
     * 로그 아웃
     */
    @GetMapping("/logoutConfirm")
    public String logoutConfirm(HttpSession session){
        log.info("logoutConfirm()");

        String nextPage = "redirect:/";

        session.removeAttribute("loginedparentsDto");

        return nextPage;
    }

    /*
     * 회원 탈퇴
     */
    @GetMapping("/deleteConfirm")
    @ResponseBody
    public Object deleteConfirm(@RequestParam int no){
        log.info("deleteConfirm()");

        int result = parentsService.deleteConfirm(no);

        Map<String, Object> map = new HashMap<>();
        map.put("result", result);

        return map;
    }

}
