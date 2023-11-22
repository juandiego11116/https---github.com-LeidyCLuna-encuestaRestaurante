package com.sura.encuesta.service;


import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;

public interface IPreguntaXEncuestaService {

    PreguntaXEncuestaDTO crearPreguntaXEncuesta(PreguntaXEncuestaDTO preguntaXEncuestaDTO);

    PreguntaXEncuestaDTO actualizarPreguntaXEncuesta(PreguntaXEncuestaDTO preguntaXEncuestaDTO);

    PreguntaXEncuestaDTO buscarPreguntaXEncuesta(PreguntaXEncuestaIdDTO preguntaXEncuestaIdDTO);

    String borrarPreguntaXEncuesta(PreguntaXEncuestaDTO preguntaXEncuestaDTO);
}

