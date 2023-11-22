package com.sura.encuesta.repository;

import com.sura.encuesta.entity.OpcionRespuestaEntity;
import com.sura.encuesta.entity.OpcionRespuestaXPreguntaEntity;
import com.sura.encuesta.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRespuestaRepository extends JpaRepository<RespuestaEntity, Integer> {

    @Query("Select e from RespuestaEntity e where idEncuesta.idEncuesta = :idEncuesta and idUsuario.idUsuario= :idUsuario")
    List<RespuestaEntity> findByIdEncuestaIdusuario(Integer idEncuesta, Integer idUsuario);

}
