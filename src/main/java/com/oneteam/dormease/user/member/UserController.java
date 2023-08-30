package com.oneteam.dormease.user.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
