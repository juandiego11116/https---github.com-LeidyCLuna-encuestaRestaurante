package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaIdEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class PreguntaXEncuestaMapping {

    private LocalDateFomatter localDateFomatter;

    public PreguntaXEncuestaEntity preguntaXEncuestaDtoToPreguntaXEncuestaEntity(
            PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        return PreguntaXEncuestaEntity.builder()
                .preguntaXEncuestaId(preguntaXEncuestaIdDtoToPreguntaXEncuestaIdEntity(preguntaXEncuestaDTO.getPreguntaXEncuestaId()))
                .activo(preguntaXEncuestaDTO.getActivo())
                .idEncuesta(new EncuestaMapping().encuestaDtoToEncuestaEntity(preguntaXEncuestaDTO.getIdEncuesta()))
                .idPregunta(new PreguntaMapping().preguntaDtoToPreguntaEntity(preguntaXEncuestaDTO.getIdPregunta()))
                .build();
    }

    public PreguntaXEncuestaIdEntity preguntaXEncuestaIdDtoToPreguntaXEncuestaIdEntity(PreguntaXEncuestaIdDTO preguntaXEncuestaIdDTO) {
        return PreguntaXEncuestaIdEntity.builder()
                .idEncuesta(preguntaXEncuestaIdDTO.getIdEncuesta())
                .idPregunta(preguntaXEncuestaIdDTO.getIdPregunta())
                .build();
    }

    public PreguntaXEncuestaDTO preguntaXEncuestaEntityToPreguntaXEncuestaDto(
            PreguntaXEncuestaEntity preguntaXEncuestaEntity) {
        return PreguntaXEncuestaDTO.builder()
                .preguntaXEncuestaId(preguntaXEncuestaIdEntityToPreguntaXEncuestaIdDto(preguntaXEncuestaEntity.getPreguntaXEncuestaId()))
                .activo(preguntaXEncuestaEntity.getActivo())
                .idEncuesta(new EncuestaMapping().encuestaEntityToEncuestaDTO(preguntaXEncuestaEntity.getIdEncuesta()))
                .idPregunta(new PreguntaMapping().preguntaEntityToPreguntaDTO(preguntaXEncuestaEntity.getIdPregunta()))
                .build();
    }

    public PreguntaXEncuestaIdDTO preguntaXEncuestaIdEntityToPreguntaXEncuestaIdDto(PreguntaXEncuestaIdEntity preguntaXEncuestaIdEntity) {
        return PreguntaXEncuestaIdDTO.builder()
                .idEncuesta(preguntaXEncuestaIdEntity.getIdEncuesta())
                .idPregunta(preguntaXEncuestaIdEntity.getIdPregunta())
                .build();
    }

    public List<PreguntaXEncuestaDTO> listPreguntaXEncuestaEntityToEPreguntaXEncuestaDTO(
            List<PreguntaXEncuestaEntity> preguntasXEncuestaEntity) {
        List<PreguntaXEncuestaDTO> preguntasXEncuestaDTO = new ArrayList<>();
        preguntasXEncuestaEntity.forEach(preguntaXEncuestaEntity -> {
            preguntasXEncuestaDTO
                    .add(preguntaXEncuestaEntityToPreguntaXEncuestaDto(preguntaXEncuestaEntity));

        });

        return preguntasXEncuestaDTO;
    }
}
