package com.oneteam.dormease.board;

import com.oneteam.dormease.user.student.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IBoardMapper {

    int insertNewContent(Map<String, Object> boardDtoMap);

    List<BoardDto> selectAllFreeBoardContent(int schoolNo);
}
