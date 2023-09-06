package com.oneteam.dormease.notice;

import com.oneteam.dormease.board.reply.IReplyMapper;
import com.oneteam.dormease.board.reply.ReplyDto;
import com.oneteam.dormease.notice.INoticeMapper;
import com.oneteam.dormease.user.student.StudentDto;
import com.oneteam.dormease.utils.UploadFileDto;
import com.oneteam.dormease.utils.pagination.Criteria;
import com.oneteam.dormease.utils.pagination.PageMakerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class NoticeService {
    private final INoticeMapper noticeMapper;
    public NoticeService (INoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

//    private static int NOTICE_BOARD_CATEGORY_NO = 0;

//    public Map<String, Object> getAllNoticeContent(String schoolNo,int pageNum, int amount) {
//        log.info("getAllFreeBoardContent()");
//        Criteria criteria = new Criteria(pageNum, amount);
//        List<NoticeDto> boardDtos = noticeMapper.selectAllNoticeContent(schoolNo, criteria);
//        int totalCnt = noticeMapper.selectCountOfNotice(schoolNo);
//        PageMakerDto pageMakerDto = new PageMakerDto(criteria, totalCnt);
//
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("boardDtos", boardDtos);
//        map.put("pageMakerDto", pageMakerDto);
//
//        return map;
//    }
//
//    public Map<String, Object> getdetailContent(int no) {
//        log.info("getdetailContent()");
//
//        NoticeDto noticeDto = new NoticeDto();
//        List<ReplyDto> replyDtos = new ArrayList<>();
//        List<UploadFileDto> uploadedFiles = new ArrayList<>();
//        Map<String, Object> boardAndReplyMap = new HashMap();
//        int result = noticeMapper.updateContentHit(no);
//
//        if (result > 0) {
//            boardDto = noticeMapper.selectDetailContent(no);
//            replyDtos = noticeMapper.selectReplies(no);
//            uploadedFiles = noticeMapper.selectUploadedFiles(no);
//        }
//        boardAndReplyMap.put("boardDto", boardDto);
//        boardAndReplyMap.put("replyDtos", replyDtos);
//        boardAndReplyMap.put("uploadedFiles", uploadedFiles);
//
//        return boardAndReplyMap;
//    }
}
