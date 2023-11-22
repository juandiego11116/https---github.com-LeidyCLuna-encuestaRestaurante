package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaIdDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.entity.*;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OpcionRespuestaXPreguntaMapping {

    private LocalDateFomatter localDateFomatter;

    public OpcionRespuestaXPreguntaEntity opcionRespuestaXPreguntaDtoToOpcionRespuestaXPreguntaEntity(
            OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        return OpcionRespuestaXPreguntaEntity.builder()
                .opcionRespuestaXPreguntaId(opcionRespuestaXPreguntaIdDtoToOpcionRespuestaXPreguntaIdEntity(opcionRespuestaXPreguntaDTO.getOpcionRespuestaXPreguntaId()))
                .idPregunta(new PreguntaMapping().preguntaDtoToPreguntaEntity(opcionRespuestaXPreguntaDTO.getIdPregunta()))
                .idOpcionRespuesta(new OpcionRespuestaMapping().opcionRespuestaDtoToOpcionRespuestaEntity(opcionRespuestaXPreguntaDTO.getIdOpcionRespuesta()))
                .activo(opcionRespuestaXPreguntaDTO.getActivo())
                .build();
    }

    public OpcionRespuestaXPreguntaIdEntity opcionRespuestaXPreguntaIdDtoToOpcionRespuestaXPreguntaIdEntity(OpcionRespuestaXPreguntaIdDTO opcionRespuestaXPreguntaIdDTO) {
        return OpcionRespuestaXPreguntaIdEntity.builder()
                .idOpcionRespuesta(opcionRespuestaXPreguntaIdDTO.getIdOpcionRespuesta())
                .idPregunta(opcionRespuestaXPreguntaIdDTO.getIdPregunta())
                .build();
    }

    public OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDto(
            OpcionRespuestaXPreguntaEntity opcionRespuestaXPreguntaEntity) {
        return OpcionRespuestaXPreguntaDTO.builder()
                .opcionRespuestaXPreguntaId(opcionRespuestaXPreguntaIdEntityToPOpcionRespuestaXPreguntaIdDto(opcionRespuestaXPreguntaEntity.getOpcionRespuestaXPreguntaId()))
                .idPregunta(new PreguntaMapping().preguntaEntityToPreguntaDTO(opcionRespuestaXPreguntaEntity.getIdPregunta()))
                .idOpcionRespuesta(new OpcionRespuestaMapping().opcionRespuestaEntityToOpcionRespuestaDto(opcionRespuestaXPreguntaEntity.getIdOpcionRespuesta()))
                .activo(opcionRespuestaXPreguntaEntity.getActivo())
                .build();
    }

    public OpcionRespuestaXPreguntaIdDTO opcionRespuestaXPreguntaIdEntityToPOpcionRespuestaXPreguntaIdDto(OpcionRespuestaXPreguntaIdEntity opcionRespuestaXPreguntaIdEntity) {
        return OpcionRespuestaXPreguntaIdDTO.builder()
                .idOpcionRespuesta(opcionRespuestaXPreguntaIdEntity.getIdOpcionRespuesta())
                .idPregunta(opcionRespuestaXPreguntaIdEntity.getIdPregunta())
                .build();
    }

    public List<OpcionRespuestaXPreguntaDTO> listOpcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDTO(
            List<OpcionRespuestaXPreguntaEntity> opcionRespuestaXPreguntaEntity) {
        List<OpcionRespuestaXPreguntaDTO> opcionRespuestaXPreguntaDTO = new ArrayList<>();
        opcionRespuestaXPreguntaEntity.forEach(OpcionRespuestaXPreguntaEntity -> {
            opcionRespuestaXPreguntaDTO
                    .add(opcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDto(OpcionRespuestaXPreguntaEntity));

        });

        return opcionRespuestaXPreguntaDTO;
    }


}
