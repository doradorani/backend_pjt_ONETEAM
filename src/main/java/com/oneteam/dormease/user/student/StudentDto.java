package com.oneteam.dormease.user.student;

import lombok.Data;

@Data
public class StudentDto {
    private int no;                 // COMMENT '학생 번호'
    private String id;              // COMMENT '학생 아이디'
    private String password;        // COMMENT '학생 비밀번호'
    private String phone;           // COMMENT '학생 전화번호'
    private String mail;            // COMMENT '학생 메일'
    private int gender;             // COMMENT '학생 성별'
    private String name;            // COMMENT '학생 이름'
    private String zip_code;        // COMMENT '학생 주소 우편번호'
    private String address;         // COMMENT '학생 주소'
    private String address_detail1; // COMMENT '학생 상세 주소1'
    private String address_detail2; // COMMENT '학생 상세 주소2'
    private String parent;          // COMMENT '부모'
    private int school_no;          // COMMENT '학교 번호'
    private String school_name;     // COMMENT '학교 이름'
    private int grade;              // COMMENT '학생 학년'
    private int class_no;           // COMMENT '학생 반'
    private int eigen_no;           // COMMENT '학생 상 벌점'
    private int dormitory;          // COMMENT '학생 기숙사 호실'
    private int point;              // COMMENT '학생 기숙사 호실'
    private int fail_count;         // COMMENT '학생 로그인 실패 횟수'
    private String reg_date;        // COMMENT '학생 등록 일자'
    private String mod_date;        // COMMENT '학생 수정 일자'
}
