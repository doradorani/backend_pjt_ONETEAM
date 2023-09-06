package com.oneteam.dormease.notice;

import com.oneteam.dormease.notice.NoticeDto;
import com.oneteam.dormease.notice.NoticeService;
import com.oneteam.dormease.user.parents.ParentsDto;
import com.oneteam.dormease.user.student.StudentDto;
import com.oneteam.dormease.utils.pagination.PageDefine;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /*
     * 자유 게시판 게시글 리스트 페이지
     */
    @GetMapping("/noticeListForm")
    public String noticeListForm(HttpSession session, Model model,
                                 @RequestParam(value="pageNum", required = false, defaultValue = PageDefine.DEFAULT_PAGE_NUMBER) int pageNum,
                                 @RequestParam(value = "amount", required = false, defaultValue = PageDefine.DEFAULT_AMOUNT) int amount) {
        log.info("noticeListForm()");
        StudentDto loginedStudentDto = (StudentDto) session.getAttribute("loginedStudentDto");
        ParentsDto loginedParentsDto = (ParentsDto) session.getAttribute("loginedParentsDto");
        String schoolNo = null;
        if (loginedStudentDto != null) {
            schoolNo = loginedStudentDto.getSchool_no();
        } else if (loginedParentsDto != null) {
//            schoolNo = loginedParentsDto.getSchool_no();
        }
//        List<NoticeDto> noticeDtos = noticeService.getAllNoticeContent(schoolNo);
        String nextPage = "notice/noticeListForm";
//        model.addAttribute("noticeDtos", noticeDtos);

        return nextPage;
    }

    /*
     * 게시글 디테일 페이지
     */
    @GetMapping("/detailContentForm")
    public String detailContentForm(@RequestParam("no") int no, Model model) {
        log.info("detailContentForm()");
        String nextPage = "notice/detailContentForm";
//        Map<String, Object> noticeAndReplyMap = noticeService.getdetailContent(no);
//        model.addAttribute("noticeAndReplyMap", noticeAndReplyMap);

        return nextPage;
    }
}
