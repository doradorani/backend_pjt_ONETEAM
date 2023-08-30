package com.oneteam.dormease.board;

import lombok.Data;

@Data
public class BoardDto {
    private int no;                 // COMMENT '글 번호'
    private int school_no;          // COMMENT '학교 번호'
    private int student_no;         // COMMENT '학생 번호'
    private int category_no;        // COMMENT '카테고리 번호'
    private String title;           // COMMENT '글 제목'
    private String content;         // COMMENT '글 내용'
    private int like;               // COMMENT '글 좋아요 수'
    private int hit;                // COMMENT '글 조회 수'
    private String reg_date;        // COMMENT '글 등록 일자'
    private String mod_date;        // COMMENT '글 수정 일자'

    private int board_no;           // COMMENT '업로드 된 게시판 보드 번호'
    private int board_attach_file;  // COMMENT '첨부파일에 추가되는 파일'
}

