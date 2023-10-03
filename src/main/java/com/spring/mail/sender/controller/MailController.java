package com.spring.mail.sender.controller;

import com.spring.mail.sender.domain.EmailDTO;
import com.spring.mail.sender.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje Recibido " + emailDTO);

        emailService.sendHtmlEmailWithInlineImage(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage(), emailDTO.getRutaImagen());
        //emailService.sendHtmlEmailWithInlineImage(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage(), (List<String>) emailDTO.getImagePaths());


        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return ResponseEntity.ok(response);
    }


}