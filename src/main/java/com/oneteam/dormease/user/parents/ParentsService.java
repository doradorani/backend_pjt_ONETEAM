package com.oneteam.dormease.user.parents;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class ParentsService {

    @Autowired
    IParentsMapper parentsMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    public int createAccountConfirm(ParentsDto parentsDto) {
        log.info("createAccountConfirm()");

        parentsDto.setPassword(passwordEncoder.encode(parentsDto.getPassword()));

        int result = parentsMapper.insertNewParent(parentsDto);

        return result;
    }

    public ParentsDto loginConfirm(ParentsDto parentsDto) {
        log.info("loginConfirm()");

        ParentsDto loginedParentsDto = parentsMapper.selectParentByID(parentsDto.getId());

        if(loginedParentsDto != null){
            if(!passwordEncoder.matches(parentsDto.getPassword(), loginedParentsDto.getPassword())){
                loginedParentsDto = null;
            }else {
                loginedParentsDto.setPassword(null);
            }
        }

        return loginedParentsDto;
    }

    public int deleteConfirm(int no) {
        log.info("deleteConfirm()");

        int result = parentsMapper.deleteParentByNo(no);

        return result;
    }
}
