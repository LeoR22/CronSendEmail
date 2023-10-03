package com.spring.mail.sender.service;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService{

    @Value("${email.sender}")
    private String emailUser;

    @Autowired
    private JavaMailSender mailSender;



    @SneakyThrows
    @Override
    public void sendHtmlEmailWithInlineImage(String[] toUser, String subject, String htmlContent, String rutaImagen) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(emailUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(htmlContent, true); // Indica que el contenido es HTML

            FileSystemResource image = new FileSystemResource(rutaImagen);
            mimeMessageHelper.addInline("img1", image);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo electrónico", e);
        }
    }


}