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

    int updateStudentPassword(String no, String id, String password);

    int updateParentPassword(String no, String id,String password);

    boolean updateStudentAuthNoBySmsDto(SmsDTO smsDTO);

    boolean updateParentAuthNoBySmsDto(SmsDTO smsDTO);

    StudentDto selectStudentBySmsDto(SmsDTO smsDTO);

    ParentsDto selectParentBySmsDto(SmsDTO smsDTO);
}
