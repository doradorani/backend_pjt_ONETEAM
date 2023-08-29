package com.oneteam.dormease.user.parents;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class ParentsService {

    @Autowired
    IParentsMapper parentsMapper;
    public int createAccountConfirm(ParentsDto parentsDto) {
        log.info("createAccountConfirm()");

        int result = parentsMapper.insertNewParent(parentsDto);

        return result;
    }

    public ParentsDto loginConfirm(ParentsDto parentsDto) {
        log.info("loginConfirm()");

        ParentsDto loginedParentsDto = parentsMapper.selectParentByID(parentsDto.getId());

        return loginedParentsDto;
    }

    public int deleteConfirm(int no) {
        log.info("deleteConfirm()");

        int result = parentsMapper.deleteParentByNo(no);

        return result;
    }
}
