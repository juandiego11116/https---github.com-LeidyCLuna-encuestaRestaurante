package com.sura.encuesta.repository;

import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEncuestaRepository extends JpaRepository<EncuestaEntity, Integer> {

}
