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
@Table(name= "opcion_respuesta_x_pregunta")
public class OpcionRespuestaXPreguntaEntity {

    @EmbeddedId
    private OpcionRespuestaXPreguntaIdEntity opcionRespuestaXPreguntaId;

    @Column(name = "activo",nullable = false)
    private Boolean activo;


    //Como los dos se llaman igual necesitamos diferenciar cual es la foranea y cual es la compuesta
    @MapsId("idOpcionRespuesta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_opcion_respuesta", nullable= false)
    private OpcionRespuestaEntity idOpcionRespuesta;

    @MapsId("idPregunta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_Pregunta", nullable= false)
    private PreguntaEntity idPregunta;
}
