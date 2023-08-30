package com.oneteam.dormease.user.member;

import com.oneteam.dormease.user.parents.ParentsDto;
import com.oneteam.dormease.user.student.StudentDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class UserService {

    @Autowired
    IUserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;


    public Map<String, Object> idDuplicationCheck(String id) {
        log.info("idDuplicationCheck()");

        boolean isDuplicateID = userMapper.selectDuplicateByID(id);

        Map<String, Object> map = new HashMap<>();

        map.put("isDuplicateID", isDuplicateID);

        return map;
    }

    public Map<String, Object> currentPasswordCheck(String currentPassword, String no, boolean isStudent) {
        log.info("currentPasswordCheck()");

        boolean check = false;

        if(isStudent){
            StudentDto studentDto = userMapper.selectStudentByNo(no);

            if(passwordEncoder.matches(currentPassword, studentDto.getPassword())){
                check = true;
            }

        } else {
            ParentsDto parentsDto = userMapper.selectParentByNo(no);

            if(passwordEncoder.matches(currentPassword, parentsDto.getPassword())){
                check = true;
            }
        }

        System.out.println(check);

        Map<String, Object> map = new HashMap<>();

        map.put("check", check);

        return map;

    }

    public int updatePassword(String no, String newPassword, boolean isStudent) {
        log.info("updatePassword()");

        String password = passwordEncoder.encode(newPassword);
        int result = -1;

        if(isStudent){
            result = userMapper.updateStudentPassword(no, password);

        } else {
            result = userMapper.updateParentPassword(no, password);

        }


        return result;
    }
}
