package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.dto.PreguntaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.mapping.EncuestaMapping;
import com.sura.encuesta.mapping.OpcionRespuestaMapping;
import com.sura.encuesta.mapping.OpcionRespuestaXPreguntaMapping;
import com.sura.encuesta.mapping.PreguntaXEncuestaMapping;
import com.sura.encuesta.repository.IEncuestaRepository;
import com.sura.encuesta.repository.IOpcionRespuestaRepository;
import com.sura.encuesta.repository.IOpcionRespuestaXPreguntaRepository;
import com.sura.encuesta.repository.IPreguntaXEncuestaRepository;
import com.sura.encuesta.service.IEncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EncuestaServiceImpl implements IEncuestaService {

    private final IEncuestaRepository iEncuestaRepository;
    private final IPreguntaXEncuestaRepository iPreguntaXEncuestaRepository;
    private final IOpcionRespuestaXPreguntaRepository iOpcionRespuestaXPreguntaRepository;
    private final IOpcionRespuestaRepository iOpcionRespuestaRepository;


    @Override
    public EncuestaDTO crearEncuesta(EncuestaDTO encuestaDTO) {
        if (Objects.nonNull(encuestaDTO)) {
            EncuestaEntity crearEncuesta = iEncuestaRepository.saveAndFlush(new EncuestaMapping().encuestaDtoToEncuestaEntity(encuestaDTO));
            if (Objects.nonNull(crearEncuesta)) {
                EncuestaDTO encuestaDTO2 = new EncuestaMapping().encuestaEntityToEncuestaDTO(crearEncuesta);
                return encuestaDTO2;
            }
        }
        return null;
    }

    @Override
    public EncuestaDTO actualizarEncuesta(EncuestaDTO encuestaDTO) {
        Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository
                .findById(encuestaDTO.getIdEncuesta());

        if (Objects.nonNull(buscarEncuesta.get())) {
            EncuestaEntity actualizarEncuesta = iEncuestaRepository
                    .saveAndFlush(new EncuestaMapping()
                            .encuestaDtoToEncuestaEntity(encuestaDTO));
            if (Objects.nonNull(actualizarEncuesta)) {
                EncuestaDTO actualizarEncuestaDTO = new EncuestaMapping()
                        .encuestaEntityToEncuestaDTO(actualizarEncuesta);
                return actualizarEncuestaDTO;
            }

        } else if (Objects.isNull(buscarEncuesta)) {

        }
        return null;
    }

    @Override
    public EncuestaDTO buscarEncuesta(Integer idEncuestaDTO) {
        Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository
                .findById(idEncuestaDTO);
        if (Objects.nonNull(buscarEncuesta)) {
            EncuestaDTO buscarEncuestaDTO = new EncuestaMapping()
                    .encuestaEntityToEncuestaDTO(buscarEncuesta.get());
            return buscarEncuestaDTO;
        }
        return null;
    }

    @Override
    public String borrarEncuesta(EncuestaDTO encuestaDTO) {
        EncuestaDTO buscarEncuestaDTO = buscarEncuesta(
                encuestaDTO.getIdEncuesta());
        if (Objects.nonNull(buscarEncuestaDTO)) {
            iEncuestaRepository
                    .delete(new EncuestaMapping()
                            .encuestaDtoToEncuestaEntity(encuestaDTO));
            return "Encuesta borrado exitosamente";
        }

        return null;
    }

    @Override
    public EncuestaDTO generarEncuesta(Integer idEncuestaDTO) {
        Optional<EncuestaEntity> buscarEncuesta = iEncuestaRepository
                .findById(idEncuestaDTO);
        if (Objects.nonNull(buscarEncuesta)) {
            EncuestaDTO buscarEncuestaDTO = new EncuestaMapping()
                    .encuestaEntityToEncuestaDTO(buscarEncuesta.get());
            buscarEncuestaDTO.setPreguntasXEncuestaDTO(consultarPreguntasEncuesta(buscarEncuestaDTO.getIdEncuesta()));
            return buscarEncuestaDTO;
        }
        return null;
    }

    public List<PreguntaXEncuestaDTO> consultarPreguntasEncuesta(Integer idEncuestaDTO) {
        List<PreguntaXEncuestaEntity> buscarPreguntasXEncuestaEntity = iPreguntaXEncuestaRepository.findByIdEncuesta(idEncuestaDTO);
        if (!buscarPreguntasXEncuestaEntity.isEmpty() && buscarPreguntasXEncuestaEntity.size() > 0 ) {
            List<PreguntaXEncuestaDTO> preguntasXEncuestaDTO = new PreguntaXEncuestaMapping().listPreguntaXEncuestaEntityToEPreguntaXEncuestaDTO(buscarPreguntasXEncuestaEntity);
            preguntasXEncuestaDTO.forEach(preguntaXEncuestaDTO -> {
                List<OpcionRespuestaXPreguntaDTO> opcionesRespuestasXPreguntaDTO = consultarOpcionRespuestaPreguntas(preguntaXEncuestaDTO.getIdPregunta().getIdPregunta());
                preguntaXEncuestaDTO.setOpcionesRespuestasXPreguntaDTO(opcionesRespuestasXPreguntaDTO);
            });
        return preguntasXEncuestaDTO;
        }
        return null;
    }


    public List<OpcionRespuestaXPreguntaDTO> consultarOpcionRespuestaPreguntas(Integer idPreguntaDto) {
        List<OpcionRespuestaXPreguntaEntity> buscarOpcionRespuestaXPreguntaEntity = iOpcionRespuestaXPreguntaRepository.findByIdPregunta(idPreguntaDto);
        if(!buscarOpcionRespuestaXPreguntaEntity.isEmpty() && buscarOpcionRespuestaXPreguntaEntity.size() > 0){
            List<OpcionRespuestaXPreguntaDTO> opcionRespuestaXPreguntaDTO = new OpcionRespuestaXPreguntaMapping().listOpcionRespuestaXPreguntaEntityToOpcionRespuestaXPreguntaDTO(buscarOpcionRespuestaXPreguntaEntity);
            return opcionRespuestaXPreguntaDTO;
        }

        return null;
    }


}

