package com.oneteam.dormease.user.member.sms;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Log4j2
@Controller
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService){
        this.smsService = smsService;
    }

    @PostMapping("/sendAuthenticationMessage")
    @ResponseBody
    public Object sendAuthenticationMessage(SmsDTO smsDTO) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        log.info("sendAuthenticationMessage()");

        return smsService.sendAuthenticationMessage(smsDTO);

    }
    @PostMapping("/sendIDMessage")
    @ResponseBody
    public Object sendIDMessage(SmsDTO smsDTO) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        log.info("sendIDMessage()");

        return smsService.sendIDMessage(smsDTO);

    }



}
