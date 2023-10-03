package com.spring.mail.sender.service;



import com.spring.mail.sender.domain.PersonaEncuesta;
import com.spring.mail.sender.domain.Persona;
import com.spring.mail.sender.repository.PersonaEncuestaRepository;
import com.spring.mail.sender.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaEncuestaServiceImpl implements IPersonaEncuestaService {

    @Autowired
    private PersonaEncuestaRepository personaEncuestaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEncuesta> getEncuestasPendientes() {
        return personaEncuestaRepository.findByEstado(1); // Cambia 1 por el valor que corresponda al estado pendiente
    }

    @Override
    public Persona getPersonaById(String idPersona) {
        return (Persona) personaRepository.findById(idPersona).orElse(null);
    }
}
