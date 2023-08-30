package com.oneteam.dormease.user.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class UserService {

    @Autowired
    IUserMapper userMapper;


    public Map<String, Object> idDuplicationCheck(String id) {
        log.info("idDuplicationCheck()");

        boolean isDuplicateID = userMapper.selectDuplicateByID(id);

        Map<String, Object> map = new HashMap<>();

        map.put("isDuplicateID", isDuplicateID);

        return map;
    }
}
