package com.oneteam.dormease.board;

import com.oneteam.dormease.utils.UploadFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IBoardMapper {

    int insertNewContent(Map<String, Object> boardDtoMap);

    void insertNewFile(List<UploadFileDto> UploadFileDtos);

    int selectCurrentBoardNo(int no);

    List<BoardDto> selectAllFreeBoardContent(int schoolNo);

    int updateContentHit(int no);

    BoardDto selectDetailContent(int no);

    List<UploadFileDto> selectUploadedFiles(int no);

    int updateContent(BoardDto boardDto);

    int updateContentForDelete(int no);

}
