package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBoardMapper {
    int insertNewContent(StudentDto loginedStudentDto, BoardDto boardDto);
}
