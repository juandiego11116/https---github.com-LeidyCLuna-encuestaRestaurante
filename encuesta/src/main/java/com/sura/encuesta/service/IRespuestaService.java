package com.sura.encuesta.service;


import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.RespuestaDTO;

import java.util.List;

public interface IRespuestaService {

    RespuestaDTO crearRespuesta(RespuestaDTO respuestaDTO);

    RespuestaDTO actualizarRespuesta(RespuestaDTO respuestaDTO);

    RespuestaDTO buscarRespuesta(Integer idRespuestaDTO);

    String borrarRespuesta(RespuestaDTO respuestaDTO);

    List<RespuestaDTO> generarRespuesta(Integer idEncuesta, Integer idUsuario);
}

