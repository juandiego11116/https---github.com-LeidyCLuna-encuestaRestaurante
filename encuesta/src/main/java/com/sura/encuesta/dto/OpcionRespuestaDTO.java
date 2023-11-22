package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class OpcionRespuestaDTO {

    @JsonProperty("id_opcion_respuesta")
    private Integer idOpcionRespuesta;

    @JsonProperty("nombre_respuesta")
    private String nombreRespuesta;

    private Boolean activo;

}
