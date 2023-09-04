package com.oneteam.dormease.user.student;

import com.oneteam.dormease.user.student.leavePass.LeavePassDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StudentService {
    private final IStudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;
    public StudentService(IStudentMapper studentMapper, PasswordEncoder passwordEncoder) {
        this.studentMapper = studentMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public int createAccountConfirm(StudentDto studentDto) {
        log.info("createAccountConfirm()");

        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));

        int result = studentMapper.insertNewStudent(studentDto);

        return result;
    }

    public StudentDto loginConfirm(StudentDto studentDto) {
        log.info("loginConfirm()");

        StudentDto loginedStudentDto = studentMapper.selectStudentByID(studentDto.getId());

        if(loginedStudentDto != null) {
            if (!passwordEncoder.matches(studentDto.getPassword(), loginedStudentDto.getPassword())) {
                loginedStudentDto = null;
            } else {
                loginedStudentDto.setPassword(null);
            }

        }

        return loginedStudentDto;

    }

    public int deleteConfirm(int no) {
        log.info("deleteConfirm()");

        int result = studentMapper.deleteStudentByNo(no);

        return result;

    }


    public int leaveOutConfirm(LeavePassDto leavePassDto) {
        log.info("leaveOutConfirm()");

        int result = studentMapper.insertNewLeaveOut(leavePassDto);

        return result;
    }
}
