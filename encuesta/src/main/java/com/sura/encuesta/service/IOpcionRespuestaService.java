package com.sura.encuesta.service;


import com.sura.encuesta.dto.OpcionRespuestaDTO;

public interface IOpcionRespuestaService {

    OpcionRespuestaDTO crearOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO);

    OpcionRespuestaDTO actualizarOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO);

    OpcionRespuestaDTO buscarOpcionRespuesta(Integer idOpcionRespuestaDTO);

    String borrarOpcionRespuesta(OpcionRespuestaDTO opcionRespuestaDTO);
}

