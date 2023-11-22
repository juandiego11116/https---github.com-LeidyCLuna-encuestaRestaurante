package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "pregunta_x_encuesta")
public class PreguntaXEncuestaEntity {

    @EmbeddedId
    private PreguntaXEncuestaIdEntity preguntaXEncuestaId;

    @Column(name = "activo",nullable = false)
    private Boolean activo;


    //Como los dos se llaman igual necesitamos diferenciar cual es la foranea y cual es la compuesta
    @MapsId("idEncuesta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_encuesta", nullable= false)
    private EncuestaEntity idEncuesta;

    @MapsId("idPregunta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_Pregunta", nullable= false)
    private PreguntaEntity idPregunta;
}
