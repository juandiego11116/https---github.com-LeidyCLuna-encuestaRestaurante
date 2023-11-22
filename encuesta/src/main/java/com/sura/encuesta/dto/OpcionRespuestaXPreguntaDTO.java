package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpcionRespuestaXPreguntaDTO {

    private OpcionRespuestaXPreguntaIdDTO opcionRespuestaXPreguntaId;

    private Boolean activo;

    @JsonProperty("id_pregunta")
    private PreguntaDTO idPregunta;

    @JsonProperty("id_opcion_respuesta")
    private OpcionRespuestaDTO idOpcionRespuesta;


}
