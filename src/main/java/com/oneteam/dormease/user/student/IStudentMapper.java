package com.oneteam.dormease.user.student;


import com.oneteam.dormease.user.student.leavePass.LeavePassDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStudentMapper {

    int insertNewStudent(StudentDto studentDto);

    StudentDto selectStudentByID(String id);

    int deleteStudentByNo(int no);

    int insertNewLeaveOut(LeavePassDto leavePassDto);

    void updateFailCount(StudentDto studentDto);
}
