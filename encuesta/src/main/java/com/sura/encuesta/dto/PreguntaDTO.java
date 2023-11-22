package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PreguntaDTO {

    @JsonProperty("id_pregunta")
    private Integer idPregunta;

    @JsonProperty("texto_pregunta")
    private String textoPregunta;
    private Boolean activo;



}
