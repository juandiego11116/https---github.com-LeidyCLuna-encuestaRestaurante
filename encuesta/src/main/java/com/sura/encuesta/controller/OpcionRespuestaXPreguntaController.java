package com.sura.encuesta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaDTO;
import com.sura.encuesta.dto.OpcionRespuestaXPreguntaIdDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaDTO;
import com.sura.encuesta.dto.PreguntaXEncuestaIdDTO;
import com.sura.encuesta.service.IOpcionRespuestaXPreguntaService;
import com.sura.encuesta.service.IPreguntaXEncuestaService;
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
@RequestMapping("/encuesta/opcionRespuestaXPregunta")
@CrossOrigin(origins = "*")
@Log4j2
public class OpcionRespuestaXPreguntaController {

    private final IOpcionRespuestaXPreguntaService iOpcionRespuestaXPreguntaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente la opcion de respuesta para la pregunta", response = OpcionRespuestaXPreguntaDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarOpcionRespuestaXPregunta(@RequestBody @Validated OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaResponse = iOpcionRespuestaXPreguntaService.crearOpcionRespuestaXPregunta(opcionRespuestaXPreguntaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaXPreguntaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarOpcionRespuestaXPregunta(@RequestBody @Validated OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaResponse = iOpcionRespuestaXPreguntaService.actualizarOpcionRespuestaXPregunta(opcionRespuestaXPreguntaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaXPreguntaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarOpcionRespuestaXPregunta(@RequestParam(value = "idPregunta") Integer idPregunta, @RequestParam(value = "idOpcionRespuesta") Integer idOpcionRespuesta) {
        OpcionRespuestaXPreguntaIdDTO opcionRespuestaXPreguntaIdDTO = new OpcionRespuestaXPreguntaIdDTO(idPregunta,idOpcionRespuesta);

        OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaResponse = iOpcionRespuestaXPreguntaService.buscarOpcionRespuestaXPregunta(opcionRespuestaXPreguntaIdDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaXPreguntaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarOpcionRespuestaXPregunta(@RequestBody @Validated OpcionRespuestaXPreguntaDTO opcionRespuestaXPreguntaDTO) {
        String opcionRespuestaXPreguntaResponse = iOpcionRespuestaXPreguntaService.borrarOpcionRespuestaXPregunta(opcionRespuestaXPreguntaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaXPreguntaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

