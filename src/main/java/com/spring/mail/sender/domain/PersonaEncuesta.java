package com.spring.mail.sender.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "persona_encuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEncuesta {

    @Id
    private String idPersonaEncuesta;

    private int estado;

    private String idReferencia;

    private String idEncuesta;

    private String idPersona;

    @Override
    public String toString() {
        return "PersonaEncuesta{" +
                "idPersonaEncuesta='" + idPersonaEncuesta + '\'' +
                ", estado=" + estado +
                ", idReferencia='" + idReferencia + '\'' +
                ", idEncuesta='" + idEncuesta + '\'' +
                ", idPersona='" + idPersona + '\'' +
                '}';
    }
}
