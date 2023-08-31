package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class BoardService {

    @Autowired
    IBoardMapper boardMapper;

    private static int FREE_BOARD_CATEGORY_NO = 1;

    public List<BoardDto> getAllFreeBoardContent(int schoolNo) {
        log.info("getAllFreeBoardContent()");

        return boardMapper.selectAllFreeBoardContent(schoolNo);
    }
    public int writeContentConfirm(StudentDto loginedStudentDto, BoardDto boardDto) {
        log.info("writeContentConfirm()");

        Map<String, Object> boardDtoMap = new HashMap<>();
        // 자유게시판 카테고리 번호 DTO에 추가
        boardDto.setCategory_no(FREE_BOARD_CATEGORY_NO);
        boardDtoMap.put("studentDto", loginedStudentDto);
        boardDtoMap.put("boardDto", boardDto);

        return boardMapper.insertNewContent(boardDtoMap);
    }

    public BoardDto getdetailContent(int no) {
        log.info("getdetailContent()");

        BoardDto boardDto = new BoardDto();
        int result = boardMapper.updateContentHit(no);

        if (result > 0) {
            boardDto = boardMapper.selectDetailContent(no);
        }
        return boardDto;
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
