package com.oneteam.dormease.user.member;

import com.oneteam.dormease.user.member.sms.SmsDTO;
import com.oneteam.dormease.user.parents.ParentsDto;
import com.oneteam.dormease.user.student.StudentDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class UserService {
    private IUserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public UserService(IUserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


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
        if (isStudent) {
            StudentDto studentDto = userMapper.selectStudentByNo(no);
            if (passwordEncoder.matches(currentPassword, studentDto.getPassword())) {
                check = true;
            }
        } else {
            ParentsDto parentsDto = userMapper.selectParentByNo(no);
            if (passwordEncoder.matches(currentPassword, parentsDto.getPassword())) {
                check = true;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("check", check);

        return map;

    }

    public int updatePassword(String no, String newPassword, boolean isStudent) {
        log.info("updatePassword()");
        String password = passwordEncoder.encode(newPassword);
        int result = -1;
        if (isStudent) {
            result = userMapper.updateStudentPassword(no, password);
        } else {
            result = userMapper.updateParentPassword(no, password);
        }
        return result;
    }

    public Map<String, Object> matchAuthentication(SmsDTO smsDTO) {
        log.info("matchAuthentication()");
        String encodedAuthNo = "";
        String id = "";
        Map<String, Object> map = new HashMap<>();
        if (smsDTO.isStudent()) {
            StudentDto studentDto = userMapper.selectStudentByNameAndPhone(smsDTO);
            if(studentDto == null){
                map.put("result", false);
                map.put("dto", false);
            } else {
                encodedAuthNo = studentDto.getAuth_no();
                id = studentDto.getId();
            }
        } else {
            ParentsDto parentsDto = userMapper.selectParentByNameAndPhone(smsDTO);
            if(parentsDto == null){
                map.put("result", false);
                map.put("dto", false);
            } else {
                encodedAuthNo = parentsDto.getAuth_no();
                id = parentsDto.getId();
            }
        }
        if (!passwordEncoder.matches(smsDTO.getContent(), encodedAuthNo)) {
            map.put("result", false);
        } else {
            map.put("result", true);
            map.put("id", id);
        }

        return map;
    }

    public Map<String, Object> invalidateAuthenticationNumber(SmsDTO smsDTO) {
        log.info("invalidateAuthenticationNumber()");

        boolean result = false;
        Map<String, Object> map = new HashMap<>();
        smsDTO.setContent(null);

        if (smsDTO.isStudent()) {
            result = userMapper.updateStudentAuthNoByNameAndPhone(smsDTO);
        } else {
            result = userMapper.updateParentAuthNoByNameAndPhone(smsDTO);
        }
        map.put("result", result);

        return map;
    }
}
