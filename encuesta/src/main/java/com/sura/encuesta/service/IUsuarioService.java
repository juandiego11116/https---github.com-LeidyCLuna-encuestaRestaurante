package com.sura.encuesta.service;


import com.sura.encuesta.dto.UsuarioDTO;

public interface IUsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarUsuario(Integer idUsuarioDTO);

    String borrarUsuario(UsuarioDTO usuarioDTO);
}

