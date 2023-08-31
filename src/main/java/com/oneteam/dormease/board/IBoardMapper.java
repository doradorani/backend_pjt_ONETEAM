package com.oneteam.dormease.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IBoardMapper {

    int insertNewContent(Map<String, Object> boardDtoMap);

    List<BoardDto> selectAllFreeBoardContent(int schoolNo);

    int updateContentHit(int no);

    BoardDto selectDetailContent(int no);

    int updateContent(BoardDto boardDto);

    int updateContentForDelete(int no);
}
