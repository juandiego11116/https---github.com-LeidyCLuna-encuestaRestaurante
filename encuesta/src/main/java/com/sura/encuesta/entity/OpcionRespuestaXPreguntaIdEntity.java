package com.sura.encuesta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OpcionRespuestaXPreguntaIdEntity {

    @Column(name = "id_pregunta",nullable = false)
    private Integer idPregunta;

    @Column(name = "id_opcion_respuesta",nullable = false)
    private Integer idOpcionRespuesta;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this)!= Hibernate.getClass(o)) return false;
        OpcionRespuestaXPreguntaIdEntity entity =(OpcionRespuestaXPreguntaIdEntity) o;
        return Objects.equals(this.idOpcionRespuesta, entity.idOpcionRespuesta) && Objects.equals(this.idPregunta, entity.idPregunta);
    }

    //La union de los dos objetos para que se comporten como unos solo
    @Override
    public int hashCode(){
        return Objects.hash(idOpcionRespuesta, idPregunta);
    }
}
