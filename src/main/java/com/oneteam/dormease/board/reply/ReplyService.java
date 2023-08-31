package com.oneteam.dormease.board.reply;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReplyService {

    @Autowired
    IReplyMapper iReplyMapper;

}
