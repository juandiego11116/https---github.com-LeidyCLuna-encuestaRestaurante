package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "encuesta")

public class EncuestaEntity {

    @Id
    @Column(name = "id_encuesta",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEncuesta;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "activo",nullable = false)
    private Boolean activo;

}
