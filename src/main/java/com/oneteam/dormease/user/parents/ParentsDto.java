package com.oneteam.dormease.user.parents;

import lombok.Data;
@Data
public class ParentsDto {
    private int no;                  // COMMENT '학부모 번호'
    private String id;               // COMMENT '학부모 아이디'
    private String password;         // COMMENT '학부모 비밀번호'
    private int student_no;          // COMMENT '학생 번호'
    private int relation;            // COMMENT '학부모 관계'
    private String phone;            // COMMENT '학부모 전화 번호'
    private String mail;             // COMMENT '학부모 메일'
    private String zip_code;         // COMMENT '학부모 집 우편번호'
    private String address;          // COMMENT '학부모 주소'
    private String address_detail1;  // COMMENT '학부모 상세 주소1'
    private String address_detail2;  // COMMENT '학부모 상세 주소2'
    private String reg_date;         // COMMENT '등록 일자'
    private String mod_date;         // COMMENT '수정 일자'
}
