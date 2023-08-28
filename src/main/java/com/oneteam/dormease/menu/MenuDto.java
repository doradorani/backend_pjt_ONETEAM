package com.oneteam.dormease.menu;

import lombok.Data;

@Data
public class MenuDto {
    private int no;                 // COMMENT '메뉴 번호'
    private int school_no;          // COMMENT '메뉴 개시 학교 번호'
    private String school_name;     // COMMENT '메뉴 개시 학교 이름'
    private String breakfast;       // COMMENT '메뉴 아침'
    private String lunch;           // COMMENT '메뉴 점심'
    private String dinner;          // COMMENT '메뉴 저녁'
    private String date;            // COMMENT '메뉴 개시 날짜'
    private String reg_date;        // COMMENT '메뉴 등록 날짜'
    private String mod_date;        // COMMENT '메뉴 수정 날짜'
}
