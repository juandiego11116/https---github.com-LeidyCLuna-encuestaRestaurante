package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pregunta")

public class PreguntaEntity {

    @Id
    @Column(name = "id_pregunta",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(name = "texto_pregunta",nullable = false)
    private String textoPregunta;

    @Column(name = "activo",nullable = false)
    private Boolean activo;
}

