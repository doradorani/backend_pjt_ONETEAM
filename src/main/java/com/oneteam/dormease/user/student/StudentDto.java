package com.oneteam.dormease.user.student;

import lombok.Data;

@Data
public class StudentDto {

    private int no;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String mail;
    private int gender;
    private String address;
    private String parent;
    private int schoolNo;
    private String schoolName;
    private int grade;
    private int classNo;
    private int eigenNo;
    private int dormitory;
    private int point;
    private int failCount;
    private String regDate;
    private String modeDate;
}
