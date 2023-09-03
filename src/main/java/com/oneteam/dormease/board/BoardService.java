package com.oneteam.dormease.board;

import com.oneteam.dormease.board.reply.IReplyMapper;
import com.oneteam.dormease.board.reply.ReplyDto;
import com.oneteam.dormease.user.student.StudentDto;
import com.oneteam.dormease.utils.UploadFileDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class BoardService {

    @Autowired
    IBoardMapper boardMapper;
    @Autowired
    IReplyMapper replyMapper;

    private static int FREE_BOARD_CATEGORY_NO = 1;

    public List<BoardDto> getAllFreeBoardContent(int schoolNo) {
        log.info("getAllFreeBoardContent()");

        return boardMapper.selectAllFreeBoardContent(schoolNo);
    }

    public Map<String, Object> getdetailContent(int no) {
        log.info("getdetailContent()");

        BoardDto boardDto = new BoardDto();
        List<ReplyDto> replyDtos = new ArrayList<>();
        List<UploadFileDto> uploadedFiles = new ArrayList<>();
        Map<String, Object> boardAndReplyMap = new HashMap();
        int result = boardMapper.updateContentHit(no);

        if (result > 0) {
            boardDto = boardMapper.selectDetailContent(no);
            replyDtos = replyMapper.selectReplies(no);
            uploadedFiles = boardMapper.selectUploadedFiles(no);
        }
        boardAndReplyMap.put("boardDto", boardDto);
        boardAndReplyMap.put("replyDtos", replyDtos);
        boardAndReplyMap.put("uploadedFiles", uploadedFiles);

        return boardAndReplyMap;
    }

    public int writeContentConfirm(StudentDto loginedStudentDto, BoardDto boardDto, List<UploadFileDto> uploadedFileDtos) {
        log.info("writeContentConfirm()");
        Map<String, Object> boardDtoMap = new HashMap<>();
        // 자유게시판 카테고리 번호 DTO에 추가
        boardDto.setCategory_no(FREE_BOARD_CATEGORY_NO);
        boardDtoMap.put("studentDto", loginedStudentDto);
        boardDtoMap.put("boardDto", boardDto);

        if (uploadedFileDtos.get(0).getBoard_attach_file() != null) {
            int currentFreeBoardNo = boardMapper.selectCurrentBoardNo(FREE_BOARD_CATEGORY_NO);
            for (int i = 0 ; i < uploadedFileDtos.size() ; i++) {
                uploadedFileDtos.get(i).setBoard_no(currentFreeBoardNo + 1);
            }
            boardMapper.insertNewFile(uploadedFileDtos);
        }
        return boardMapper.insertNewContent(boardDtoMap);
    }

    public BoardDto getdetailContentForModify(int no) {
        log.info("getdetailContentForModify()");

        return boardMapper.selectDetailContent(no);
    }

    public int modifyContentConfirm(BoardDto boardDto) {
        log.info("getdetailContentForModify()");

        return boardMapper.updateContent(boardDto);
    }

    public int deleteContentConfirm(int no) {
        log.info("deleteContentConfirm()");

        return boardMapper.updateContentForDelete(no);
    }
}
