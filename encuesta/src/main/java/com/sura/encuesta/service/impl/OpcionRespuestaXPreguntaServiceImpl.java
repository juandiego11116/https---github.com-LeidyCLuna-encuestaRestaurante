package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaIdDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.mapping.OpcionRespuestaXPreguntaMapping;
import com.sura.encuesta.mapping.PreguntaXEncuestaMapping;
import com.sura.encuesta.repository.IOpcionRespuestaXPreguntaRepository;
import com.sura.encuesta.repository.IPreguntaXEncuestaRepository;
import com.sura.encuesta.service.IOpcionRespuestaXPreguntaService;
import com.sura.encuesta.service.IPreguntaXEncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OpcionRespuestaXPreguntaServiceImpl implements IOpcionRespuestaXPreguntaService {

    private final IOpcionRespuestaXPreguntaRepository iOpcionRespuestaXPreguntaRepository;

    @Override
    public OpcionRespuestaXPreguntaDTO crearOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        if (Objects.nonNull(opcionRespuestaXPreguntaDTO)) {
            OpcionRespuestaXPreguntaEntity crearOpcionRespuestaXPregunta = iOpcionRespuestaXPreguntaRepository.saveAndFlush(new OpcionRespuestaXPreguntaMapping().opcionRespuestaXPreguntaDtoToOpcionRespuestaXPreguntaEntity(opcionRespuestaXPreguntaDTO));
            if (Objects.nonNull(crearOpcionRespuestaXPregunta)) {
                OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO2 = new OpcionRespuestaXPreguntaMapping().opcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDto(crearOpcionRespuestaXPregunta);
                return opcionRespuestaXPreguntaDTO2;
            }
        }
        return null;
    }

    @Override
    public OpcionRespuestaXPreguntaDTO actualizarOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        Optional<OpcionRespuestaXPreguntaEntity> buscarOpcionRespuestaXPregunta = iOpcionRespuestaXPreguntaRepository
                .findById(new OpcionRespuestaXPreguntaMapping().opcionRespuestaXPreguntaIdDtoToOpcionRespuestaXPreguntaIdEntity(opcionRespuestaXPreguntaDTO.getOpcionRespuestaXPreguntaId()));

        if (Objects.nonNull(buscarOpcionRespuestaXPregunta.get())) {
            OpcionRespuestaXPreguntaEntity actualizarOpcionRespuestaXPregunta = iOpcionRespuestaXPreguntaRepository
                    .saveAndFlush(new OpcionRespuestaXPreguntaMapping()
                            .opcionRespuestaXPreguntaDtoToOpcionRespuestaXPreguntaEntity(opcionRespuestaXPreguntaDTO));
            if (Objects.nonNull(actualizarOpcionRespuestaXPregunta)) {
                OpcionRespuestaXPreguntaDTO actualizarOpcionRespuestaXPreguntaDTO = new OpcionRespuestaXPreguntaMapping()
                        .opcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDto(actualizarOpcionRespuestaXPregunta);
                return actualizarOpcionRespuestaXPreguntaDTO;
            }

        } else if (Objects.isNull(buscarOpcionRespuestaXPregunta)) {

        }
        return null;
    }

    @Override
    public OpcionRespuestaXPreguntaDTO buscarOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaIdDTO OpcionRespuestaXPreguntaIdDTO) {
        Optional<OpcionRespuestaXPreguntaEntity> buscarOpcionRespuestaXPregunta = iOpcionRespuestaXPreguntaRepository
                .findById(new OpcionRespuestaXPreguntaMapping().opcionRespuestaXPreguntaIdDtoToOpcionRespuestaXPreguntaIdEntity(OpcionRespuestaXPreguntaIdDTO));
        if (Objects.nonNull(buscarOpcionRespuestaXPregunta)) {
            OpcionRespuestaXPreguntaDTO buscarOpcionRespuestaXPreguntaDTO = new OpcionRespuestaXPreguntaMapping()
                    .opcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDto(buscarOpcionRespuestaXPregunta.get());
            return buscarOpcionRespuestaXPreguntaDTO;
        }
        return null;
    }

    @Override
    public String borrarOpcionRespuestaXPregunta (OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        OpcionRespuestaXPreguntaDTO buscarOpcionRespuestaXPreguntaDTO = buscarOpcionRespuestaXPregunta(
                opcionRespuestaXPreguntaDTO.getOpcionRespuestaXPreguntaId());
        if (Objects.nonNull(buscarOpcionRespuestaXPreguntaDTO)) {
            iOpcionRespuestaXPreguntaRepository
                    .delete(new OpcionRespuestaXPreguntaMapping()
                            .opcionRespuestaXPreguntaDtoToOpcionRespuestaXPreguntaEntity(opcionRespuestaXPreguntaDTO));
            return "Opcion de respuesta borrada de la pregunta exitosamente";
        }

        return null;
    }

}

