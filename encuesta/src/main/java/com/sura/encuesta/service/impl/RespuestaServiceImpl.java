package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.RespuestaDTO;
import com.sura.encuesta.entity.RespuestaEntity;
import com.sura.encuesta.mapping.RespuestaMapping;
import com.sura.encuesta.repository.IRespuestaRepository;
import com.sura.encuesta.service.IRespuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RespuestaServiceImpl implements IRespuestaService {

    private final IRespuestaRepository iRespuestaRepository;

    @Override
    public RespuestaDTO crearRespuesta(RespuestaDTO respuestaDTO) {
        if (Objects.nonNull(respuestaDTO)) {
            RespuestaEntity crearRespuesta = iRespuestaRepository.saveAndFlush(new RespuestaMapping().respuestaDtoToRespuestaEntity(respuestaDTO));
            if (Objects.nonNull(crearRespuesta)) {
                RespuestaDTO respuestaDTO2 = new RespuestaMapping().respuestaEntityToRespuestaDto(crearRespuesta);
                return respuestaDTO2;
            }
        }
        return null;
    }

    @Override
    public RespuestaDTO actualizarRespuesta(RespuestaDTO respuestaDTO) {
        Optional<RespuestaEntity> buscarRespuesta = iRespuestaRepository
                .findById(respuestaDTO.getIdRespuesta());

        if (Objects.nonNull(buscarRespuesta.get())) {
            RespuestaEntity actualizarRespuesta = iRespuestaRepository
                    .saveAndFlush(new RespuestaMapping()
                            .respuestaDtoToRespuestaEntity(respuestaDTO));
            if (Objects.nonNull(actualizarRespuesta)) {
                RespuestaDTO actualizarRespuestaDTO = new RespuestaMapping()
                        .respuestaEntityToRespuestaDto(actualizarRespuesta);
                return actualizarRespuestaDTO;
            }

        } else if (Objects.isNull(buscarRespuesta)) {

        }
        return null;
    }

    @Override
    public RespuestaDTO buscarRespuesta(Integer idRespuestaDTO) {
        Optional<RespuestaEntity> buscarRespuesta = iRespuestaRepository
                .findById(idRespuestaDTO);
        if (Objects.nonNull(buscarRespuesta)) {
            RespuestaDTO buscarRespuestaDTO = new RespuestaMapping()
                    .respuestaEntityToRespuestaDto(buscarRespuesta.get());
            return buscarRespuestaDTO;
        }
        return null;
    }

    @Override
    public String borrarRespuesta(RespuestaDTO respuestaDTO) {
        RespuestaDTO buscarRespuestaDTO = buscarRespuesta(
                respuestaDTO.getIdRespuesta());
        if (Objects.nonNull(buscarRespuestaDTO)) {
            iRespuestaRepository
                    .delete(new RespuestaMapping()
                            .respuestaDtoToRespuestaEntity(respuestaDTO));
            return "Respuesta borrada exitosamente";
        }

        return null;
    }

    @Override
    public List<RespuestaDTO> generarRespuesta(Integer idEncuesta, Integer idUsuario) {
        List<RespuestaEntity> buscarRespuesta = iRespuestaRepository
                .findByIdEncuestaIdusuario(idEncuesta,idUsuario);
        if (Objects.nonNull(buscarRespuesta)) {
            List<RespuestaDTO> buscarRespuestaDTO = new RespuestaMapping().listRespuestaEntityToRespuestaDTO(buscarRespuesta);
            return buscarRespuestaDTO;
        }
        return null;
    }

}

