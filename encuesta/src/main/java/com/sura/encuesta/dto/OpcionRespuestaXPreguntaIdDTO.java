package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpcionRespuestaXPreguntaIdDTO {

    @JsonProperty("id_pregunta")
    private Integer idPregunta;

    @JsonProperty("id_opcion_respuesta")
    private Integer idOpcionRespuesta;

}
