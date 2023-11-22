package com.sura.encuesta.service;


import com.sura.encuesta.dto.EncuestaDTO;

public interface IEncuestaService {

    EncuestaDTO crearEncuesta(EncuestaDTO encuestaDTO);

    EncuestaDTO actualizarEncuesta(EncuestaDTO encuestaDTO);

    EncuestaDTO buscarEncuesta(Integer idEncuestaDTO);

    String borrarEncuesta(EncuestaDTO encuestaDTO);

    //Metodo principal para generar la encuesta con sus respectivas preguntas y opciones de respuesta.
    EncuestaDTO generarEncuesta(Integer idEncuestaDTO);
}

