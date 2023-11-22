package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuesta")

public class RespuestaEntity implements Serializable {

    @Id
    @Column(name = "id_respuesta",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRespuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_usuario", nullable= false)
    private UsuarioEntity idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_Pregunta", nullable= false)
    private PreguntaEntity idPregunta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_opcion_respuesta", nullable= false)
    private OpcionRespuestaEntity idOpcionRespuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_encuesta", nullable= false)
    private EncuestaEntity idEncuesta;

    @Column(name = "respuesta_abierta")
    private String respuestaAbierta;

    @Column(name = "fecha_respuesta",nullable = false)
    private LocalDate fechaRespuesta;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this)!= Hibernate.getClass(o)) return false;
        RespuestaEntity entity =(RespuestaEntity) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) && Objects.equals(this.idPregunta, entity.idPregunta) && Objects.equals(this.idOpcionRespuesta, entity.idOpcionRespuesta)&& Objects.equals(this.idEncuesta, entity.idEncuesta);
    }

    //La union de los dos objetos para que se comporten como unos solo
    @Override
    public int hashCode(){
        return Objects.hash(idRespuesta,idOpcionRespuesta, idPregunta, idUsuario, idEncuesta);
    }


}
