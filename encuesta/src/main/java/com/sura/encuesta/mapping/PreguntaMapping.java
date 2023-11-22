package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.PreguntaDTO;
import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.PreguntaEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PreguntaMapping {

    private LocalDateFomatter localDateFomatter;

    public PreguntaEntity preguntaDtoToPreguntaEntity(
            PreguntaDTO preguntaDTO) {
        return PreguntaEntity.builder()
                .idPregunta(preguntaDTO.getIdPregunta())
                .textoPregunta(preguntaDTO.getTextoPregunta())
                .activo(preguntaDTO.getActivo())
                .build();
    }

    public PreguntaDTO preguntaEntityToPreguntaDTO(
            PreguntaEntity preguntaEntity) {
        return PreguntaDTO.builder()
                .idPregunta(preguntaEntity.getIdPregunta())
                .textoPregunta(preguntaEntity.getTextoPregunta())
                .activo(preguntaEntity.getActivo())
                .build();
    }
}
