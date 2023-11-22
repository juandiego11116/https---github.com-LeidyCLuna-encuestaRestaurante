package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.OpcionRespuestaDTO;
import com.sura.encuesta.entity.OpcionRespuestaEntity;
import com.sura.encuesta.mapping.OpcionRespuestaMapping;
import com.sura.encuesta.repository.IOpcionRespuestaRepository;
import com.sura.encuesta.service.IOpcionRespuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OpcionRespuestaServiceImpl implements IOpcionRespuestaService {

    private final IOpcionRespuestaRepository iOpcionRespuestaRepository;

    @Override
    public OpcionRespuestaDTO crearOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO) {
        if (Objects.nonNull(opcionRespuestaDTO)) {
            OpcionRespuestaEntity crearOpcionRespuesta = iOpcionRespuestaRepository.saveAndFlush(new OpcionRespuestaMapping().opcionRespuestaDtoToOpcionRespuestaEntity(opcionRespuestaDTO));
            if (Objects.nonNull(crearOpcionRespuesta)) {
                OpcionRespuestaDTO opcionRespuestaDTO2 = new OpcionRespuestaMapping().opcionRespuestaEntityToOpcionRespuestaDto(crearOpcionRespuesta);
                return opcionRespuestaDTO2;
            }
        }
        return null;
    }

    @Override
    public OpcionRespuestaDTO actualizarOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO) {
        Optional<OpcionRespuestaEntity> buscarOpcionRespuesta = iOpcionRespuestaRepository
                .findById(opcionRespuestaDTO.getIdOpcionRespuesta());

        if (Objects.nonNull(buscarOpcionRespuesta.get())) {
            OpcionRespuestaEntity actualizarOpcionRespuesta = iOpcionRespuestaRepository
                    .saveAndFlush(new OpcionRespuestaMapping()
                            .opcionRespuestaDtoToOpcionRespuestaEntity(opcionRespuestaDTO));
            if (Objects.nonNull(actualizarOpcionRespuesta)) {
                OpcionRespuestaDTO actualizarOpcionRespuestaDTO = new OpcionRespuestaMapping()
                        .opcionRespuestaEntityToOpcionRespuestaDto(actualizarOpcionRespuesta);
                return actualizarOpcionRespuestaDTO;
            }

        } else if (Objects.isNull(buscarOpcionRespuesta)) {

        }
        return null;
    }

    @Override
    public OpcionRespuestaDTO buscarOpcionRespuesta(Integer idOpcionRespuestaDTO) {
        Optional<OpcionRespuestaEntity> buscarOpcionRespuesta = iOpcionRespuestaRepository
                .findById(idOpcionRespuestaDTO);
        if (Objects.nonNull(buscarOpcionRespuesta)) {
            OpcionRespuestaDTO buscarOpcionRespuestaDTO = new OpcionRespuestaMapping()
                    .opcionRespuestaEntityToOpcionRespuestaDto(buscarOpcionRespuesta.get());
            return buscarOpcionRespuestaDTO;
        }
        return null;
    }

    @Override
    public String borrarOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO) {
        OpcionRespuestaDTO buscarOpcionRespuestaDTO = buscarOpcionRespuesta(
                opcionRespuestaDTO.getIdOpcionRespuesta());
        if (Objects.nonNull(buscarOpcionRespuestaDTO)) {
            iOpcionRespuestaRepository
                    .delete(new OpcionRespuestaMapping()
                            .opcionRespuestaDtoToOpcionRespuestaEntity(opcionRespuestaDTO));
            return "La opcion de respuesta se ha borrado exitosamente";
        }

        return null;
    }

}

