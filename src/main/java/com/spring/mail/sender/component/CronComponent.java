package com.spring.mail.sender.component;


import com.spring.mail.sender.domain.PersonaEncuesta;
import com.spring.mail.sender.domain.Persona;
import com.spring.mail.sender.service.IEmailService;
import com.spring.mail.sender.service.IPersonaEncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class CronComponent {

    @Autowired
    private IEmailService emailService;

    @Autowired
    private IPersonaEncuestaService personaEncuestaService;
    @Scheduled(cron = "0 * * * * ?") // Ejecutar cada minuto
    //@Scheduled(cron = "0 */5 * * * ?") // Ejecutar cada  5 minutos
    //@Scheduled(cron = "0 0 8 * * ?") // Ejecutar todos los días a las 8:00 AM
    public void executeCronJob() {
        System.out.println("Tarea programada ejecutada a las " + LocalDateTime.now());
        List<PersonaEncuesta> encuestasPendientes = personaEncuestaService.getEncuestasPendientes();

        for (PersonaEncuesta encuesta : encuestasPendientes) {
            if (encuesta.getEstado() == 1) {
                // Obtener el correo de la persona
                Persona persona = personaEncuestaService.getPersonaById(encuesta.getIdPersona());
                String correo = persona.getCorreo();

                // Construir contenido HTML con imagen
                String htmlContent = "<html><body>";
                //htmlContent += "<img src='cid:img2'>";
                htmlContent += "<h1>Diligenciamiento encuesta cursos VSTI</h1>";
                htmlContent += "<p>Estamos validando y falta Diligenciamiento de una encuesta asociado a tu curso Valko.</p>";
                htmlContent += "<p>Tu compromiso con el cumplimiento de las acciones de formación es vital para que los recursos destinados a este fin sean efectivos. Velar por el correcto uso de los recursos que la Organización pone a nuestra disposición, es responsabilidad de todos.</p>";
                htmlContent += "<img src='cid:img1'>";
                htmlContent += "</body></html>";

                // Especifica la ruta de la imagen en el servidor
                //List<String> rutaImagen = "src/main/resources/static/imagen.jpg";
                //String rutaImagen2 = "src/main/resources/static/imagen-2.png";
                //List<String> imagePaths = Arrays.asList(rutaImagen1);
                String rutaImagen = "src/main/resources/static/imagen.jpg";
                // Enviar el correo con contenido HTML y la imagen incrustada
                String asunto = "\uD83D\uDCE2 NOVEDADES VALKO| Encuesta de satisfacción";
                //emailService.sendHtmlEmailWithInlineImage(new String[]{correo}, asunto, htmlContent, imagePaths);
                emailService.sendHtmlEmailWithInlineImage(new String[]{correo}, asunto, htmlContent, rutaImagen);
                System.out.println("Tarea ejecutada");
            }
        }
    }
}
