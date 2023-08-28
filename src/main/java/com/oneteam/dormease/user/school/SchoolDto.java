package com.oneteam.dormease.user.school;

import lombok.Data;

@Data
public class SchoolDto {
    private int   no;               // COMMENT '학교 번호'
    private String zip_code;        // COMMENT '학교 우편 번호'
    private String name;            // COMMENT '학교 이름'
    private String address;         // COMMENT '학교 주소'
    private String url;             // COMMENT '학교 URL 주소'
}
