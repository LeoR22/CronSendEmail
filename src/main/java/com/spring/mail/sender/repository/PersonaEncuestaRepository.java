package com.spring.mail.sender.repository;


import com.spring.mail.sender.domain.PersonaEncuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaEncuestaRepository extends JpaRepository<PersonaEncuesta, String> {

    List<PersonaEncuesta> findByEstado(int estado);

}
