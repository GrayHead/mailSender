package com.example.mail.controllers;

import com.example.mail.services.CustomMailSernder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@RestController
@AllArgsConstructor
public class MainController {


    private CustomMailSernder sernder;


    // /mail&mail=asd@asd.com
    @GetMapping("/mail")
    public void mail(@RequestParam String mail) {
        sernder.send(mail);
    }


//    @GetMapping("/reg")
//    public void reg(user) {
//        dao.save(user)
//        srender.send(user)
//    }
//
//    @GetMapping("/confirm")
//    public void confirm(@RequestParam int id) {
//
//        user = dao.find(id);
//        dao.enable(user)
//    }


}
