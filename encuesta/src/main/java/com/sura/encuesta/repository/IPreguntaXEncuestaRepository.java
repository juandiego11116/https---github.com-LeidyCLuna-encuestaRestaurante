package com.sura.encuesta.repository;

import com.sura.encuesta.entity.PreguntaXEncuestaEntity;
import com.sura.encuesta.entity.PreguntaXEncuestaIdEntity;
import com.sura.encuesta.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPreguntaXEncuestaRepository extends JpaRepository<PreguntaXEncuestaEntity, PreguntaXEncuestaIdEntity> {


    @Query("Select e from PreguntaXEncuestaEntity e where preguntaXEncuestaId.idEncuesta = :idEncuesta")
    List<PreguntaXEncuestaEntity> findByIdEncuesta(Integer idEncuesta);
}
