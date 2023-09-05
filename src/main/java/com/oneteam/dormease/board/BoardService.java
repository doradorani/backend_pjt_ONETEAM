package com.oneteam.dormease.board;

import com.oneteam.dormease.board.reply.IReplyMapper;
import com.oneteam.dormease.board.reply.ReplyDto;
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
public class BoardService {
    private final IBoardMapper boardMapper;
    private final IReplyMapper replyMapper;
    public BoardService (IBoardMapper boardMapper, IReplyMapper replyMapper) {
        this.boardMapper = boardMapper;
        this.replyMapper = replyMapper;
    }

    private static int FREE_BOARD_CATEGORY_NO = 1;

    public Map<String, Object> getAllFreeBoardContent(String schoolNo,int pageNum, int amount) {
        log.info("getAllFreeBoardContent()");
        Criteria criteria = new Criteria(pageNum, amount);
        Map<String, Object> map = new HashMap<>();
        map.put("schoolNo", schoolNo);
        map.put("criteria", criteria);
        List<BoardDto> boardDtos = boardMapper.selectAllFreeBoardContent(map);
        int totalCnt = boardMapper.selectCountOfContent(schoolNo);

        PageMakerDto pageMakerDto = new PageMakerDto(criteria, totalCnt);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("boardDtos", boardDtos);
        resultMap.put("pageMakerDto", pageMakerDto);

        return resultMap;
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
        int result = -1;
//        int uploadResult = -1;
        Map<String, Object> boardDtoMap = new HashMap<>();
        // 자유게시판 카테고리 번호 DTO에 추가
        boardDto.setCategory_no(FREE_BOARD_CATEGORY_NO);
        boardDtoMap.put("studentDto", loginedStudentDto);
        boardDtoMap.put("boardDto", boardDto);

        if (uploadedFileDtos != null && !uploadedFileDtos.isEmpty()) {
            int currentFreeBoardNo = boardMapper.selectCurrentBoardNo(FREE_BOARD_CATEGORY_NO);
            for (int i = 0 ; i < uploadedFileDtos.size() ; i++) {
                uploadedFileDtos.get(i).setBoard_no(currentFreeBoardNo + 1);
            }
            boardMapper.insertNewFile(uploadedFileDtos);
        }
        result = boardMapper.insertNewContent(boardDtoMap);
        return result;
    }

    public Map<String, Object> getdetailContentForModify(int no) {
        log.info("getdetailContentForModify()");
        Map<String, Object> boardAndReplyMap = new HashMap();
        BoardDto boardDto = boardMapper.selectDetailContent(no);
        List<UploadFileDto> uploadedFiles = boardMapper.selectUploadedFiles(no);
        boardAndReplyMap.put("boardDto", boardDto);
        boardAndReplyMap.put("uploadedFiles", uploadedFiles);

        return boardAndReplyMap;
    }

    public int modifyContentConfirm(BoardDto boardDto,
                                    List<UploadFileDto> uploadedFileDtos,
                                    List<String> board_attach_files) {
        log.info("getdetailContentForModify()");
        int result = -1;
        int deleteResult = -1;
        int boardNoForModify = boardDto.getNo();
        List<UploadFileDto> uploadedFileCheck = new ArrayList<>();
        uploadedFileCheck = boardMapper.selectUploadedFiles(boardNoForModify);

        // 사용자가 수정시 파일을 첨부한 경우
        if (uploadedFileDtos != null && !uploadedFileDtos.isEmpty()) {
            // 기존에 첨부된 파일이 있는 경우
            if (uploadedFileCheck != null && !uploadedFileCheck.isEmpty()) {
                deleteResult = boardMapper.deleteFilesForModify(boardNoForModify);
                // 새로 등록된 첨부파일 DB에 등록
                if (deleteResult > 0) {
                    for (int i = 0 ; i < uploadedFileDtos.size() ; i++) {
                        uploadedFileDtos.get(i).setBoard_no(boardNoForModify);
                    }
                    boardMapper.insertNewFile(uploadedFileDtos);
                }
            // 기존에 첨부된 파일이 없는 경우 ==> 새로 등록된 첨부파일 DB에 등록
            } else {
                for (int i = 0 ; i < uploadedFileDtos.size() ; i++) {
                    uploadedFileDtos.get(i).setBoard_no(boardNoForModify);
                }
                boardMapper.insertNewFile(uploadedFileDtos);
            }

        // 사용자가 수정시 파일을 첨부하지 않은 경우
        } else {
            // 사용자가 기존의 첨부파일을 삭제한 경우
            if (board_attach_files == null) {
                boardMapper.deleteFilesForModify(boardNoForModify);
            }
        }
        result = boardMapper.updateContent(boardDto);

        return result;
    }

    public int deleteContentConfirm(int no) {
        log.info("deleteContentConfirm()");

        return boardMapper.updateContentForDelete(no);
    }
}
