package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sura.encuesta.entity.PreguntaXEncuestaIdEntity;
import lombok.*;

import java.util.List;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaXEncuestaDTO {

    private PreguntaXEncuestaIdDTO preguntaXEncuestaId;

    private Boolean activo;

    @JsonProperty("id_encuesta")
    private EncuestaDTO idEncuesta;

    @JsonProperty("id_pregunta")
    private PreguntaDTO idPregunta;

    private List<OpcionRespuestaXPreguntaDTO> opcionesRespuestasXPreguntaDTO;



}
