package com.oneteam.dormease.board.reply;

import lombok.Data;

@Data
public class ReplyDto {
    private int no;                 //COMMENT '답글 번호'
    private int school_no;          //COMMENT '답글 학교 번호'
    private int student_no;         //COMMENT '답글 학생 번호'
    private int board_no;           //COMMENT '답글 게시판 번호'
    private String comment;         // COMMENT '답글 내용'
    private int group;              //COMMENT '답글 그룹'
    private int step;               //COMMENT '답글 스텝'
    private int indent;             //COMMENT '답글 인덴트'
    private String reg_date;        // COMMENT '답글 등록 날짜'
    private String mod_date;        //COMMENT '답글 수정 날짜'
}
