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
import org.springframework.web.bind.annotation.RequestParam;

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
        int result = boardService.writeContentConfirm(loginedStudentDto, boardDto);
        String nextpage = "/board/writeContentResult";
        model.addAttribute("result", result);

        return nextpage;
    }

    @GetMapping("/detailContentForm")
    public String detailContentForm(@RequestParam("no") int no, Model model) {
        log.info("detailContentForm()");
        String nextPage = "/board/detailContentForm";
        BoardDto boardDto = boardService.getdetailContent(no);
        model.addAttribute("boardDto", boardDto);

        return nextPage;
    }

    @PostMapping("/modifyContentForm")
    public String modifyContentForm(@RequestParam("no") int no, Model model) {
        log.info("modifyContentForm()");
        String nextPage = "/board/modifyContentForm";
        BoardDto boardDto = boardService.getdetailContentForModify(no);
        model.addAttribute("boardDto", boardDto);

        return nextPage;
    }

    @PostMapping("/modifyContentConfirm")
    public String modifyContentConfirm(BoardDto boardDto, Model model) {
        log.info("modifyContentConfirm()");
        String nextPage = "/board/modifyContentResult";
        int result = boardService.modifyContentConfirm(boardDto);
        model.addAttribute("result", result);

        return nextPage;
    }

    @GetMapping("/deleteContentConfirm")
    public String deleteContentConfirm(int no, Model model) {
        log.info("deleteContentConfirm()");
        String nextPage = "/board/deleteContentResult";
        int result = boardService.deleteContentConfirm(no);
        model.addAttribute("result", result);

        return nextPage;
    }
}
