package com.sura.encuesta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.dto.UsuarioDTO;
import com.sura.encuesta.service.IPreguntaXEncuestaService;
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
@RequestMapping("/encuesta/preguntaXEncuesta")
@CrossOrigin(origins = "*")
@Log4j2
public class PreguntaXEncuestaController {

    private final IPreguntaXEncuestaService iPreguntaXEncuestaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente la pregunta para la encuesta", response = PreguntaXEncuestaDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarPreguntaXEncuesta(@RequestBody @Validated PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        PreguntaXEncuestaDTO preguntaXEncuestaResponse = iPreguntaXEncuestaService.crearPreguntaXEncuesta(preguntaXEncuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntaXEncuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarPreguntaXEncuesta(@RequestBody @Validated PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        PreguntaXEncuestaDTO preguntaXEncuestaResponse = iPreguntaXEncuestaService.actualizarPreguntaXEncuesta(preguntaXEncuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntaXEncuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarPreguntaXEncuesta(@RequestParam(value = "idEncuesta") Integer idEncuesta, @RequestParam(value = "idPregunta") Integer idPregunta) {
        PreguntaXEncuestaIdDTO preguntaXEncuestaIdDTO = new PreguntaXEncuestaIdDTO(idEncuesta,idPregunta);

        PreguntaXEncuestaDTO preguntaXEncuestaResponse = iPreguntaXEncuestaService.buscarPreguntaXEncuesta(preguntaXEncuestaIdDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntaXEncuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarPreguntaXEncuesta(@RequestBody @Validated PreguntaXEncuestaDTO preguntaXEncuestaDTO) {
        String preguntaXEncuestaResponse = iPreguntaXEncuestaService.borrarPreguntaXEncuesta(preguntaXEncuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(preguntaXEncuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

