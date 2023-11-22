package com.sura.encuesta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento",nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "sexo",nullable = false)
    private String sexo;

}

