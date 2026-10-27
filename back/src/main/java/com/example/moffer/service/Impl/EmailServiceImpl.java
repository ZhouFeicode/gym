package com.example.moffer.service.Impl;

import jakarta.annotation.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl {
    @Resource
    private JavaMailSender javaMailSender;
public boolean email(List<String> to,String subject,String text){
    for(int i=0;i<to.size();i++){
    SimpleMailMessage s=new SimpleMailMessage();
    s.setFrom("amailabao@sina.com");
    s.setTo(to.get(i));
    s.setSubject(subject);
    s.setText(text);
    javaMailSender.send(s);
}
return true;
}}
