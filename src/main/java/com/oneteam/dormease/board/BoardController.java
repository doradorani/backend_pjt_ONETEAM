package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/writeContentForm")
    public String writeContentForm() {
        log.info("writeContentForm()");

        String nextpage = "/board/writeContentForm";

        return nextpage;
    }

    @GetMapping("/writeContentConfirm")
    public String writeContentConfirm(HttpSession session, Model model, BoardDto boardDto) {
        log.info("writeContentConfirm()");

        StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");

        int result = boardService.writeContentConfirm(loginedStudentDto, boardDto);

        String nextpage = "/board/writeContentResult";

        model.addAttribute("result", result);

        return nextpage;
    }
}
