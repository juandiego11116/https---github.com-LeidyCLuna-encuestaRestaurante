package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.OpcionRespuestaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OpcionRespuestaMapping {

    private LocalDateFomatter localDateFomatter;

    public OpcionRespuestaEntity opcionRespuestaDtoToOpcionRespuestaEntity(
            OpcionRespuestaDTO opcionRespuestaDTO) {
        return OpcionRespuestaEntity.builder()
                .idOpcionRespuesta(opcionRespuestaDTO.getIdOpcionRespuesta())
                .nombreRespuesta(opcionRespuestaDTO.getNombreRespuesta())
                .activo(opcionRespuestaDTO.getActivo())
                .build();
    }

    public OpcionRespuestaDTO opcionRespuestaEntityToOpcionRespuestaDto(
            OpcionRespuestaEntity opcionRespuestaEntity) {
        return OpcionRespuestaDTO.builder()
                .idOpcionRespuesta(opcionRespuestaEntity.getIdOpcionRespuesta())
                .nombreRespuesta(opcionRespuestaEntity.getNombreRespuesta())
                .activo(opcionRespuestaEntity.getActivo())
                .build();
    }

    public List<OpcionRespuestaDTO> listOpcionRespuestaEntityToOpcionRespuestaDTO(
            List<OpcionRespuestaEntity> opcionRespuestaEntity) {
        List<OpcionRespuestaDTO> opcionRespuestaDTO = new ArrayList<>();
        opcionRespuestaEntity.forEach(OpcionRespuestaEntity -> {
            opcionRespuestaDTO
                    .add(opcionRespuestaEntityToOpcionRespuestaDto(OpcionRespuestaEntity));

        });

        return opcionRespuestaDTO;
    }
}
