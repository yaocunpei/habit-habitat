package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
@Service
public class SendEmailServicelmpl  implements  SendEmailService{
    @Autowired
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private  String from;
    public boolean sendJunkMail(String toMail,String subject,String content){
        try {
            MimeMessage messageM = this.mailSender.createMimeMessage();
            MimeMessageHelper message=new MimeMessageHelper(messageM);
            message.setTo(toMail);
            message.setSubject(subject);
            message.setText(content);
            message.setFrom(from);
            mailSender.send(messageM);
        }catch (Exception ex){
            return Boolean.FALSE;
        }
        return  Boolean.TRUE;
    }
}
