package com.sura.encuesta.repository;

import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreguntaRepository extends JpaRepository<PreguntaEntity, Integer> {

}
