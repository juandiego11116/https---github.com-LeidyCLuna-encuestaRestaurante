package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaXEncuestaIdDTO {

    @JsonProperty("id_encuesta")
    private Integer idEncuesta;

    @JsonProperty("id_pregunta")
    private Integer idPregunta;

}
