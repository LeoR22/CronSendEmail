package com.spring.mail.sender.service;


public interface IEmailService {
    void sendHtmlEmailWithInlineImage(String[] toUser, String subject, String htmlContent, String rutaImagen);
}


