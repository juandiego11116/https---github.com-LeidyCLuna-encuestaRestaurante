package com.sura.encuesta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.dto.RespuestaDTO;
import com.sura.encuesta.service.IRespuestaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/encuesta/respuesta")
@CrossOrigin(origins = "*")
@Log4j2
public class RespuestaController {

    private final IRespuestaService iRespuestaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente la respuesta", response = RespuestaDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarRespuesta(@RequestBody @Validated RespuestaDTO respuestaDTO) {
        RespuestaDTO respuestaResponse = iRespuestaService.crearRespuesta(respuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(respuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarRespuesta(@RequestBody @Validated RespuestaDTO respuestaDTO) {
        RespuestaDTO respuestaResponse = iRespuestaService.actualizarRespuesta(respuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(respuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarRespuesta(@RequestParam(value = "idRespuestaDTO") Integer idRespuestaDTO ) {
        RespuestaDTO respuestaResponse = iRespuestaService.buscarRespuesta(idRespuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(respuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }*/

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarRespuesta(@RequestBody @Validated RespuestaDTO respuestaDTO) {
        String respuestaResponse = iRespuestaService.borrarRespuesta(respuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(respuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generarRespuesta(@RequestParam(value = "idEncuesta") Integer idEncuesta, @RequestParam(value = "idUsuario") Integer idUsuario) {

        List<RespuestaDTO> respuestasResponse = iRespuestaService.generarRespuesta(idEncuesta,idUsuario);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(respuestasResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

