package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RespuestaDTO {

    @JsonProperty("id_respuesta")
    private Integer idRespuesta;

    @JsonProperty("id_usuario")
    private UsuarioDTO idUsuario;

    @JsonProperty("id_pregunta")
    private PreguntaDTO idPregunta;

    @JsonProperty("id_opcion_respuesta")
    private OpcionRespuestaDTO idOpcionRespuesta;

    @JsonProperty("id_encuesta")
    private EncuestaDTO idEncuesta;

    @JsonProperty("respuesta_abierta")
    private String respuestaAbierta;

    @JsonProperty("fecha_respuesta")
    private String fechaRespuesta;

}
