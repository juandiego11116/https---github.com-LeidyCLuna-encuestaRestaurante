package com.sura.encuesta.repository;

import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaIdEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOpcionRespuestaXPreguntaRepository extends JpaRepository<OpcionRespuestaXPreguntaEntity, OpcionRespuestaXPreguntaIdEntity> {

    @Query("Select e from OpcionRespuestaXPreguntaEntity e where opcionRespuestaXPreguntaId.idPregunta = :idPregunta")
    List<OpcionRespuestaXPreguntaEntity> findByIdPregunta(Integer idPregunta);
}
