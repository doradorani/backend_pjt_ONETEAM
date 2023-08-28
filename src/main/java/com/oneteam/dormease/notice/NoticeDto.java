package com.oneteam.dormease.notice;

import lombok.Data;

@Data
public class NoticeDto {
    private int no;                     // COMMENT '공지사항 번호',
    private int school_no;              // COMMENT '공지사항 개시 학교 번호'
    private String title;               // COMMENT '공지사항 제목'
    private String content;             // COMMENT '공지사항 내용'
    private int hit;                    // COMMENT '공지사항 조회 수'
    private int fix;                    // COMMENT '공지사항 상단 개시 여부'
    private int open;                   // COMMENT '공지사항 개시 여부'
    private String start_date;          // COMMENT '공지사항 시작 날짜'
    private String end_date;            // COMMENT '공지사항 종료 날짜'
    private String reg_date;            // COMMENT '공지사항 등록 날짜'
    private String mod_date;            // COMMENT '공지사항 수정 날짜'

    private int notice_no;              // COMMENT '업로드 된 공지사항 보드 번호'
    private int notice_attach_file;     // COMMENT '첨부파일에 추가되는 파일'
}
