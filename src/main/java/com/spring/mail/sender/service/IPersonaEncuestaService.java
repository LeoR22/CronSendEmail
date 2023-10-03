package com.spring.mail.sender.service;



import com.spring.mail.sender.domain.PersonaEncuesta;
import com.spring.mail.sender.domain.Persona;

import java.util.List;

public interface IPersonaEncuestaService {
    List<PersonaEncuesta> getEncuestasPendientes();
    Persona getPersonaById(String idPersona);
}
