package com.oneteam.dormease.user.student;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStudentMapper {

    int insertNewStudent(StudentDto studentDto);

    StudentDto selectStudentByID(String id);

    int deleteStudentByNo(int no);

}
