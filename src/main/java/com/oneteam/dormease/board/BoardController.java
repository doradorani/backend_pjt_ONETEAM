package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/freeBoardListForm")
    public String freeBoardListForm(HttpSession session, Model model) {
        log.info("freeBoardListForm()");

        StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");
        int schoolNo = loginedStudentDto.getSchool_no();
        List<BoardDto> boardDtos = boardService.getAllFreeBoardContent(schoolNo);

//        System.out.println("=====>" + boardDtos);

        String nextPage = "/board/freeBoardListForm";

        model.addAttribute("boardDtos", boardDtos);

        return nextPage;
    }

    @GetMapping("/writeContentForm")
    public String writeContentForm() {
        log.info("writeContentForm()");

        String nextpage = "/board/writeContentForm";

        return nextpage;
    }

    @PostMapping("/writeContentConfirm")
    public String writeContentConfirm(HttpSession session, Model model, BoardDto boardDto) {
        log.info("writeContentConfirm()");

        StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");
        log.info("loginedStudentDto===>" + loginedStudentDto);

        int result = boardService.writeContentConfirm(loginedStudentDto, boardDto);

        String nextpage = "/board/writeContentResult";

        model.addAttribute("result", result);

        return nextpage;
    }
}
