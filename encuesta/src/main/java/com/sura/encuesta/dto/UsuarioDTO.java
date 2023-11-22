package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {

    @JsonProperty("id_usuario")
    private Integer idUsuario;

    private String nombre;

    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;

    private String sexo;

}
