package com.sura.encuesta.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EncuestaDTO {

    @JsonProperty("id_encuesta")
    private Integer idEncuesta;

    private String nombre;
    private String descripcion;
    private Boolean activo;

    private List<PreguntaXEncuestaDTO> preguntasXEncuestaDTO;

}
