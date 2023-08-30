package com.oneteam.dormease.user.member;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/user/member")
public class UserController {


    @Autowired
    UserService userService;


    /*
     * 로그인 폼
     */


    @GetMapping("/loginForm")
    public String loginForm(){
        log.info("loginForm()");

        return "/user/loginForm";
    }

    /*
     * 아이디 중복 여부 체크
     */

    @GetMapping("/idDuplicationCheck")
    @ResponseBody
    public Object idDuplicationCheck(@RequestParam String id) {
        log.info("idDuplicationCheck()");

        Map<String, Object> map = userService.idDuplicationCheck(id);

        return map;

    }


    /*
     * 비밀번호 수정 폼
     */

    @GetMapping("/updatePasswordForm")
    public String updatePasswordForm(@RequestParam int no, @RequestParam boolean isStudent, Model model) {
        log.info("updatePasswordForm()");

        String nextPage = "/user/member/updatePasswordForm";

        model.addAttribute("no", no);
        model.addAttribute("isStudent", isStudent);

        return nextPage;

    }

    /*
     * 비밀번호 수정 확인
     */
    @PostMapping("/currentPasswordCheck")
    @ResponseBody
    public Object currentPasswordCheck(@RequestBody Map<String, String> msgDto) {
        log.info("currentPasswordCheck()");

        boolean isStudent = Boolean.parseBoolean(msgDto.get("isStudent"));

        Map<String, Object> map = userService.currentPasswordCheck(msgDto.get("currentPassword"), msgDto.get("no"),isStudent);

        return map;

    }/*
     * 비밀번호 수정 확인
     */
    @PostMapping("/updatePasswordConfirm")
    public String updatePassword(@RequestParam("no") String no, @RequestParam String newPassword, @RequestParam boolean isStudent) {
        log.info("updatePassword()");

        int result = userService.updatePassword(no, newPassword, isStudent);

        String nextPage = "";

        if(result > 0){
             nextPage = "redirect:/";
        } else {
            nextPage = "redirect:/user/member/loginForm";
        }

        return nextPage;

    }



}
