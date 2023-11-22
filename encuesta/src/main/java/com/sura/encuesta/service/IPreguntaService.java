package com.sura.encuesta.service;


import com.sura.encuesta.dto.PreguntaDTO;

public interface IPreguntaService {

    PreguntaDTO crearPregunta(PreguntaDTO preguntaDTO);

    PreguntaDTO actualizarPregunta(PreguntaDTO preguntaDTO);

    PreguntaDTO buscarPregunta(Integer idPreguntaDTO);

    String borrarPregunta(PreguntaDTO preguntaDTO);
}

