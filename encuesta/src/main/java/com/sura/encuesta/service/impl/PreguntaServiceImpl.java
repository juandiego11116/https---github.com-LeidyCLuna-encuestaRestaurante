package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.PreguntaDTO;
import com.sura.encuesta.entity.PreguntaEntity;
import com.sura.encuesta.mapping.PreguntaMapping;
import com.sura.encuesta.repository.IPreguntaRepository;
import com.sura.encuesta.service.IPreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaServiceImpl implements IPreguntaService {

    private final IPreguntaRepository iPreguntaRepository;

    @Override
    public PreguntaDTO crearPregunta(PreguntaDTO preguntaDTO) {
        if (Objects.nonNull(preguntaDTO)) {
            PreguntaEntity crearPregunta = iPreguntaRepository.saveAndFlush(new PreguntaMapping().preguntaDtoToPreguntaEntity(preguntaDTO));
            if (Objects.nonNull(crearPregunta)) {
                PreguntaDTO preguntaDTO2 = new PreguntaMapping().preguntaEntityToPreguntaDTO(crearPregunta);
                return preguntaDTO2;
            }
        }
        return null;
    }

    @Override
    public PreguntaDTO actualizarPregunta(PreguntaDTO preguntaDTO) {
        Optional<PreguntaEntity> buscarPregunta = iPreguntaRepository
                .findById(preguntaDTO.getIdPregunta());

        if (Objects.nonNull(buscarPregunta.get())) {
            PreguntaEntity actualizarPregunta = iPreguntaRepository
                    .saveAndFlush(new PreguntaMapping()
                            .preguntaDtoToPreguntaEntity(preguntaDTO));
            if (Objects.nonNull(actualizarPregunta)) {
                PreguntaDTO actualizarPreguntaDTO = new PreguntaMapping()
                        .preguntaEntityToPreguntaDTO(actualizarPregunta);
                return actualizarPreguntaDTO;
            }

        } else if (Objects.isNull(buscarPregunta)) {

        }
        return null;
    }

    @Override
    public PreguntaDTO buscarPregunta(Integer idPreguntaDTO) {
        Optional<PreguntaEntity> buscarPregunta = iPreguntaRepository
                .findById(idPreguntaDTO);
        if (Objects.nonNull(buscarPregunta)) {
            PreguntaDTO buscarPreguntaDTO = new PreguntaMapping()
                    .preguntaEntityToPreguntaDTO(buscarPregunta.get());
            return buscarPreguntaDTO;
        }
        return null;
    }

    @Override
    public String borrarPregunta(PreguntaDTO preguntaDTO) {
        PreguntaDTO buscarPreguntaDTO = buscarPregunta(
                preguntaDTO.getIdPregunta());
        if (Objects.nonNull(buscarPreguntaDTO)) {
            iPreguntaRepository
                    .delete(new PreguntaMapping()
                            .preguntaDtoToPreguntaEntity(preguntaDTO));
            return "Pregunta borrada exitosamente";
        }

        return null;
    }

}


