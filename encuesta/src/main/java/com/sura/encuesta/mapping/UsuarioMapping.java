package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.UsuarioDTO;
import com.sura.encuesta.entity.UsuarioEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioMapping {

    private LocalDateFomatter localDateFomatter;

    public UsuarioEntity usuarioDtoToUsuarioEntity(
            UsuarioDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .idUsuario(usuarioDTO.getIdUsuario())
                .nombre(usuarioDTO.getNombre())
                .fechaNacimiento(new LocalDateFomatter().dateStringtoLocalDate(usuarioDTO.getFechaNacimiento()))
                .sexo(usuarioDTO.getSexo())
                .build();
    }

    public UsuarioDTO usuarioEntityToUsuarioDTO(
            UsuarioEntity usuarioEntity) {
        return UsuarioDTO.builder()
                .idUsuario(usuarioEntity.getIdUsuario())
                .nombre(usuarioEntity.getNombre())
                .fechaNacimiento(new LocalDateFomatter().LocalDateToStringDate(usuarioEntity.getFechaNacimiento()))
                .sexo(usuarioEntity.getSexo())
                .build();
    }
}
