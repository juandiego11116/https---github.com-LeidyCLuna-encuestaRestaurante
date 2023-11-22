package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.mapping.PreguntaXEncuestaMapping;
import com.sura.encuesta.repository.IPreguntaXEncuestaRepository;
import com.sura.encuesta.service.IPreguntaXEncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaXEncuestaServiceImpl implements IPreguntaXEncuestaService {

    private final IPreguntaXEncuestaRepository iPreguntaXEncuestaRepository;

    @Override
    public PreguntaXEncuestaDTO crearPreguntaXEncuesta(PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        if (Objects.nonNull(preguntaXEncuestaDTO)) {
            PreguntaXEncuestaEntity crearPreguntaXEncuesta = iPreguntaXEncuestaRepository.saveAndFlush(new PreguntaXEncuestaMapping().preguntaXEncuestaDtoToPreguntaXEncuestaEntity(preguntaXEncuestaDTO));
            if (Objects.nonNull(crearPreguntaXEncuesta)) {
                PreguntaXEncuestaDTO preguntaXEncuestaDTO2 = new PreguntaXEncuestaMapping().preguntaXEncuestaEntityToPreguntaXEncuestaDto(crearPreguntaXEncuesta);
                return preguntaXEncuestaDTO2;
            }
        }
        return null;
    }

    @Override
    public PreguntaXEncuestaDTO actualizarPreguntaXEncuesta(PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        Optional<PreguntaXEncuestaEntity> buscarPreguntaXEncuesta = iPreguntaXEncuestaRepository
                .findById(new PreguntaXEncuestaMapping().preguntaXEncuestaIdDtoToPreguntaXEncuestaIdEntity(preguntaXEncuestaDTO.getPreguntaXEncuestaId()));

        if (Objects.nonNull(buscarPreguntaXEncuesta.get())) {
            PreguntaXEncuestaEntity actualizarPreguntaXEncuesta = iPreguntaXEncuestaRepository
                    .saveAndFlush(new PreguntaXEncuestaMapping()
                            .preguntaXEncuestaDtoToPreguntaXEncuestaEntity(preguntaXEncuestaDTO));
            if (Objects.nonNull(actualizarPreguntaXEncuesta)) {
                PreguntaXEncuestaDTO actualizarPreguntaXEncuestaDTO = new PreguntaXEncuestaMapping()
                        .preguntaXEncuestaEntityToPreguntaXEncuestaDto(actualizarPreguntaXEncuesta);
                return actualizarPreguntaXEncuestaDTO;
            }

        } else if (Objects.isNull(buscarPreguntaXEncuesta)) {

        }
        return null;
    }

    @Override
    public PreguntaXEncuestaDTO buscarPreguntaXEncuesta(PreguntaXEncuestaIdDTO preguntaXEncuestaIdDTO) {
        Optional<PreguntaXEncuestaEntity> buscarPreguntaXEncuesta = iPreguntaXEncuestaRepository
                .findById(new PreguntaXEncuestaMapping().preguntaXEncuestaIdDtoToPreguntaXEncuestaIdEntity(preguntaXEncuestaIdDTO));
        if (Objects.nonNull(buscarPreguntaXEncuesta)) {
            PreguntaXEncuestaDTO buscarPreguntaXEncuestaDTO = new PreguntaXEncuestaMapping()
                    .preguntaXEncuestaEntityToPreguntaXEncuestaDto(buscarPreguntaXEncuesta.get());
            return buscarPreguntaXEncuestaDTO;
        }
        return null;
    }

    @Override
    public String borrarPreguntaXEncuesta (PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        PreguntaXEncuestaDTO buscarPreguntaXEncuestaDTO = buscarPreguntaXEncuesta(
                preguntaXEncuestaDTO.getPreguntaXEncuestaId());
        if (Objects.nonNull(buscarPreguntaXEncuestaDTO)) {
            iPreguntaXEncuestaRepository
                    .delete(new PreguntaXEncuestaMapping()
                            .preguntaXEncuestaDtoToPreguntaXEncuestaEntity(preguntaXEncuestaDTO));
            return "Pregunta borrada de la encuesta exitosamente";
        }

        return null;
    }

}

