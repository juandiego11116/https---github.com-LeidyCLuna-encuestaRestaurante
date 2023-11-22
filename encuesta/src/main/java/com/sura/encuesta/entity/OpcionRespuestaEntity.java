package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opcion_respuesta")

public class OpcionRespuestaEntity {

    @Id
    @Column(name = "id_opcion_respuesta",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpcionRespuesta;

    @Column(name = "nombre_respuesta",nullable = false)
    private String nombreRespuesta;

    @Column(name = "activo",nullable = false)
    private Boolean activo;
}
