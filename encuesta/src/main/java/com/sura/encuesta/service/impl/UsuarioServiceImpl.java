package com.sura.encuesta.service.impl;


import com.sura.encuesta.dto.UsuarioDTO;
import com.sura.encuesta.entity.UsuarioEntity;
import com.sura.encuesta.mapping.UsuarioMapping;
import com.sura.encuesta.repository.IUsuarioRepository;
import com.sura.encuesta.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.nonNull(usuarioDTO)) {
            UsuarioEntity crearUsuario = iUsuarioRepository.saveAndFlush(new UsuarioMapping().usuarioDtoToUsuarioEntity(usuarioDTO));
            if (Objects.nonNull(crearUsuario)) {
                UsuarioDTO usuarioDTO2 = new UsuarioMapping().usuarioEntityToUsuarioDTO(crearUsuario);
                return usuarioDTO2;
            }
        }
        return null;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> buscarUsuario = iUsuarioRepository
                .findById(usuarioDTO.getIdUsuario());

        if (Objects.nonNull(buscarUsuario.get())) {
            UsuarioEntity actualizarUsuario = iUsuarioRepository
                    .saveAndFlush(new UsuarioMapping()
                            .usuarioDtoToUsuarioEntity(usuarioDTO));
            if (Objects.nonNull(actualizarUsuario)) {
                UsuarioDTO actualizarUsuarioDTO = new UsuarioMapping()
                        .usuarioEntityToUsuarioDTO(actualizarUsuario);
                return actualizarUsuarioDTO;
            }

        } else if (Objects.isNull(buscarUsuario)) {

        }
        return null;
    }

    @Override
    public UsuarioDTO buscarUsuario(Integer idUsuarioDTO) {
        Optional<UsuarioEntity> buscarUsuario = iUsuarioRepository
                .findById(idUsuarioDTO);
        if (Objects.nonNull(buscarUsuario)) {
            UsuarioDTO buscarUsuarioDTO = new UsuarioMapping()
                    .usuarioEntityToUsuarioDTO(buscarUsuario.get());
            return buscarUsuarioDTO;
        }
        return null;
    }

    @Override
    public String borrarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO buscarUsuarioDTO = buscarUsuario(
                usuarioDTO.getIdUsuario());
        if (Objects.nonNull(buscarUsuarioDTO)) {
            iUsuarioRepository
                    .delete(new UsuarioMapping()
                            .usuarioDtoToUsuarioEntity(usuarioDTO));
            return "Usuario borrado exitosamente";
        }

        return null;
    }

}

