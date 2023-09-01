package com.oneteam.dormease.board.reply;

import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Log4j2
@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/registReply")
    public Object registReply(HttpSession session, @RequestBody Map<String, String> replyMap) {
        log.info("registReply()");
        StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");
        replyMap.put("student_name", loginedStudentDto.getName());

//        return replyService.registReply(replyMap);
        return null;
    }
}
