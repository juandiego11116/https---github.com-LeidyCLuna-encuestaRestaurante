package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.RespuestaDTO;
import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.entity.RespuestaEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RespuestaMapping {

    private LocalDateFomatter localDateFomatter;

    public RespuestaEntity respuestaDtoToRespuestaEntity(
            RespuestaDTO respuestaDTO) {
        return RespuestaEntity.builder()
                .idRespuesta(respuestaDTO.getIdRespuesta())
                .idUsuario(new UsuarioMapping().usuarioDtoToUsuarioEntity(respuestaDTO.getIdUsuario()))
                .idPregunta(new PreguntaMapping().preguntaDtoToPreguntaEntity(respuestaDTO.getIdPregunta()))
                .idOpcionRespuesta(new OpcionRespuestaMapping().opcionRespuestaDtoToOpcionRespuestaEntity(respuestaDTO.getIdOpcionRespuesta()))
                .idEncuesta(new EncuestaMapping().encuestaDtoToEncuestaEntity(respuestaDTO.getIdEncuesta()))
                .respuestaAbierta(respuestaDTO.getRespuestaAbierta())
                .fechaRespuesta(new LocalDateFomatter().dateStringtoLocalDate(respuestaDTO.getFechaRespuesta()))
                .build();
    }

    public RespuestaDTO respuestaEntityToRespuestaDto(
            RespuestaEntity respuestaEntity) {
        return RespuestaDTO.builder()
                .idRespuesta(respuestaEntity.getIdRespuesta())
                .idUsuario(new UsuarioMapping().usuarioEntityToUsuarioDTO(respuestaEntity.getIdUsuario()))
                .idPregunta(new PreguntaMapping().preguntaEntityToPreguntaDTO(respuestaEntity.getIdPregunta()))
                .idOpcionRespuesta(new OpcionRespuestaMapping().opcionRespuestaEntityToOpcionRespuestaDto(respuestaEntity.getIdOpcionRespuesta()))
                .idEncuesta(new EncuestaMapping().encuestaEntityToEncuestaDTO(respuestaEntity.getIdEncuesta()))
                .respuestaAbierta(respuestaEntity.getRespuestaAbierta())
                .fechaRespuesta(new LocalDateFomatter().LocalDateToStringDate(respuestaEntity.getFechaRespuesta()))
                .build();
    }

    public List<RespuestaDTO> listRespuestaEntityToRespuestaDTO(
            List<RespuestaEntity> respuestasEntity) {
        List<RespuestaDTO> respuestaDTO = new ArrayList<>();
        respuestasEntity.forEach(respuestaEntity -> {
            respuestaDTO
                    .add(respuestaEntityToRespuestaDto(respuestaEntity));

        });

        return respuestaDTO;
    }
}
