package com.oneteam.dormease.user.member;

import com.oneteam.dormease.user.member.sms.SmsDTO;
import com.oneteam.dormease.user.parents.ParentsDto;
import com.oneteam.dormease.user.student.StudentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    boolean selectDuplicateByID(String id);

    StudentDto selectStudentByNo(String no);

    ParentsDto selectParentByNo(String no);

    int updateStudentPassword(String no, String password);

    int updateParentPassword(String no, String password);

    boolean updateStudentAuthNoByNameAndPhone(SmsDTO smsDTO);

    boolean updateParentAuthNoByNameAndPhone(SmsDTO smsDTO);

    StudentDto selectStudentByNameAndPhone(SmsDTO smsDTO);

    ParentsDto selectParentByNameAndPhone(SmsDTO smsDTO);
}
