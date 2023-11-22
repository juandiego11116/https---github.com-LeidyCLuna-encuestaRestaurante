package com.sura.encuesta.repository;

import com.sura.encuesta.entity.OpcionRespuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOpcionRespuestaRepository extends JpaRepository<OpcionRespuestaEntity, Integer> {

    @Query("Select e from OpcionRespuestaEntity e where idOpcionRespuesta = :idOpcionRespuesta")
    List<OpcionRespuestaEntity> findByIdOpcionRespuesta(Integer idOpcionRespuesta);
}
