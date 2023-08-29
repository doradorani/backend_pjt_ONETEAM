package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class BoardService {

    @Autowired
    IBoardMapper boardMapper;
    public int writeContentConfirm(StudentDto loginedStudentDto, BoardDto boardDto) {
        log.info("writeContentConfirm()");

        log.info("loginedStudentDto==>" + loginedStudentDto);
        log.info("boardDto===========>" + boardDto);

        Map<String, Object> boardDtoMap = new HashMap<>();
        boardDtoMap.put("studentDto", loginedStudentDto);
        boardDtoMap.put("boardDto", boardDto);

        return boardMapper.insertNewContent(boardDtoMap);
    }
}
