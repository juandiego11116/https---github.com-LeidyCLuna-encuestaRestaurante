package com.sura.encuesta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.UsuarioDTO;
import com.sura.encuesta.service.IUsuarioService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/encuesta/usuario")
@CrossOrigin(origins = "*")
@Log4j2
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente el usuario", response = UsuarioDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioResponse = iUsuarioService.crearUsuario(usuarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioResponse = iUsuarioService.actualizarUsuario(usuarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarUsuario(@RequestParam(value = "idUsuarioDTO") Integer idUsuarioDTO ) {
        UsuarioDTO usuarioResponse = iUsuarioService.buscarUsuario(idUsuarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        String usuarioResponse = iUsuarioService.borrarUsuario(usuarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

