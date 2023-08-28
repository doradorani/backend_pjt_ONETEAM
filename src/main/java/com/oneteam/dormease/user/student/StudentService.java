package com.oneteam.dormease.user.student;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class StudentService {

    @Autowired
    IStudentMapper studentMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    public int createAccountConfirm(StudentDto studentDto) {
        log.info("createAccountConfirm()");

        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));

        int result = studentMapper.insertNewStudent(studentDto);

        return result;
    }

    public StudentDto loginConfirm(StudentDto studentDto) {
        log.info("loginConfirm()");

        StudentDto loginedStudentDto = studentMapper.selectStudentByID(studentDto.getId());
        System.out.println(loginedStudentDto.getId());

        if(loginedStudentDto != null) {
            if (!passwordEncoder.matches(studentDto.getPassword(), loginedStudentDto.getPassword())) {
                loginedStudentDto = null;
            }

        }

        System.out.println(loginedStudentDto.getId());

        return loginedStudentDto;

    }
}
