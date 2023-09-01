package com.oneteam.dormease.user.school;

import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;
import lombok.Data;

@Data
public class SchoolDto {
    private @SQLInjectionSafe int   no;               // COMMENT '학교 번호'
    private @SQLInjectionSafe String zip_code;        // COMMENT '학교 우편 번호'
    private @SQLInjectionSafe String name;            // COMMENT '학교 이름'
    private @SQLInjectionSafe String address;         // COMMENT '학교 주소'
    private @SQLInjectionSafe String url;             // COMMENT '학교 URL 주소'
}
