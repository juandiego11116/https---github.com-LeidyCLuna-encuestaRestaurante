package com.sura.encuesta.service;


import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaIdDTO;

public interface IOpcionRespuestaXPreguntaService {

    OpcionRespuestaXPreguntaDTO crearOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO);

    OpcionRespuestaXPreguntaDTO actualizarOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO);

    OpcionRespuestaXPreguntaDTO buscarOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaIdDTO opcionRespuestaXPreguntaIdDTO);

    String borrarOpcionRespuestaXPregunta(OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO);
}

