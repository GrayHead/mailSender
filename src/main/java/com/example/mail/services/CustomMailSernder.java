package com.example.mail.services;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@PropertySource("classpath:application.properties")
public class CustomMailSernder {


    private JavaMailSender javaMailSender;
    private Environment env;

    public void send(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
//            mimeMessage.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
            helper.setText("<h1>message  <a href='http://localhost:8080/confirm?id=100500'> pres here to confirm</a></h1>", true);
//            helper.addAttachment("someAttach", null, "text/plain");
            helper.setTo(email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);

    }

}
