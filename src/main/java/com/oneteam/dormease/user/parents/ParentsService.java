package com.oneteam.dormease.user.parents;

import com.oneteam.dormease.user.student.StudentDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class ParentsService {
    private final IParentsMapper parentsMapper;
    private final PasswordEncoder passwordEncoder;
    public ParentsService (IParentsMapper parentsMapper, PasswordEncoder passwordEncoder) {
        this.parentsMapper = parentsMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public int createAccountConfirm(ParentsDto parentsDto) {
        log.info("createAccountConfirm()");

        parentsDto.setPassword(passwordEncoder.encode(parentsDto.getPassword()));

        int result = parentsMapper.insertNewParent(parentsDto);

        return result;
    }

    public Map<String, Object> loginConfirm(ParentsDto parentsDto) {
        log.info("loginConfirm()");

        ParentsDto loginedParentsDto = parentsMapper.selectParentByID(parentsDto.getId());
        Map<String, Object> map = new HashMap<>();
        if(loginedParentsDto != null) {
            if (!passwordEncoder.matches(parentsDto.getPassword(), loginedParentsDto.getPassword())) {
                parentsMapper.updateFailCount(parentsDto);
                map.put("fail_count", loginedParentsDto.getFail_count() + 1);
                map.put("result", false);
                loginedParentsDto = null;
            } else {
                if(loginedParentsDto.getFail_count() >=5){
                    map.put("fail_count", loginedParentsDto.getFail_count());
                    loginedParentsDto = null;
                    map.put("result", false);
                } else {
                    loginedParentsDto.setPassword(null);
                    parentsMapper.updateFailCount(loginedParentsDto);
                    loginedParentsDto.setFail_count(0);
                    map.put("fail_count", 0);
                    map.put("result", true);
                }
            }
        }
        map.put("loginedParentsDto", loginedParentsDto);
        return map;
    }

    public int deleteConfirm(int no) {
        log.info("deleteConfirm()");
        int result = parentsMapper.deleteParentByNo(no);

        return result;
    }

    public Object searchStudents(StudentDto studentDto) {
        log.info("searchStudents()");
        Map<String, Object> map = new HashMap<>();
        List<StudentDto> studentDtos =  parentsMapper.selectStudents(studentDto);
        map.put("studentDtos", studentDtos);

        return map;
    }
}
