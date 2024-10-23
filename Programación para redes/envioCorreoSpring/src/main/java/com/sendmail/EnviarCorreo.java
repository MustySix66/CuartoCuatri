package com.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class EnviarCorreo {
    @Autowired
    private JavaMailSender mail;

    @PostMapping("enviarCorreo")
    public ResponseEntity<?> enviar_correo(){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("hernandezxa412@gmail.com");
        email.setFrom("kevinandrade259@gmail.com");
        email.setSubject("sos gilipolla");
        email.setText("Chupala");
        mail.send(email);

        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
