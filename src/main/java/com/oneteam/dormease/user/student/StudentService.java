package com.oneteam.dormease.user.student;

import com.oneteam.dormease.user.student.leavePass.LeavePassDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Object> loginConfirm(StudentDto studentDto) {
        log.info("loginConfirm()");

        StudentDto loginedStudentDto = studentMapper.selectStudentByID(studentDto.getId());
        Map<String, Object> map = new HashMap<>();
        if(loginedStudentDto != null) {
            if (!passwordEncoder.matches(studentDto.getPassword(), loginedStudentDto.getPassword())) {
                studentMapper.updateFailCount(studentDto);
                map.put("fail_count", loginedStudentDto.getFail_count() + 1);
                map.put("result", false);
                loginedStudentDto = null;
            } else {
                if(loginedStudentDto.getFail_count() >=5){
                    map.put("fail_count", loginedStudentDto.getFail_count());
                    loginedStudentDto = null;
                    map.put("result", false);
                } else {
                    loginedStudentDto.setPassword(null);
                    studentMapper.updateFailCount(loginedStudentDto);
                    loginedStudentDto.setFail_count(0);
                    map.put("fail_count", 0);
                    map.put("result", true);
                }
            }
        }
        map.put("loginedStudentDto", loginedStudentDto);

        return map;

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
