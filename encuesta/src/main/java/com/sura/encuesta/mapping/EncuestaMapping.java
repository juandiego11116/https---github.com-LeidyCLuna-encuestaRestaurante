package com.sura.encuesta.mapping;

import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.entity.EncuestaEntity;
import com.sura.encuesta.entity.UsuarioEntity;
import com.sura.encuesta.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EncuestaMapping {

    private LocalDateFomatter localDateFomatter;

    public EncuestaEntity encuestaDtoToEncuestaEntity(
            EncuestaDTO encuestaDTO) {
        return EncuestaEntity.builder()
                .idEncuesta(encuestaDTO.getIdEncuesta())
                .nombre(encuestaDTO.getNombre())
                .descripcion(encuestaDTO.getDescripcion())
                .activo(encuestaDTO.getActivo())
                .build();
    }

    public EncuestaDTO encuestaEntityToEncuestaDTO(
            EncuestaEntity encuestaEntity) {
        return EncuestaDTO.builder()
                .idEncuesta(encuestaEntity.getIdEncuesta())
                .nombre(encuestaEntity.getNombre())
                .descripcion(encuestaEntity.getDescripcion())
                .activo(encuestaEntity.getActivo())
                .build();
    }
}
