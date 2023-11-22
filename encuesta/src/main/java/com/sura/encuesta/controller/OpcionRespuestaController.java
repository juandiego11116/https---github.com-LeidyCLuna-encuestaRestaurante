package com.sura.encuesta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.OpcionRespuestaDTO;
import com.sura.encuesta.service.IOpcionRespuestaService;
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
@RequestMapping("/encuesta/opcionRespuesta")
@CrossOrigin(origins = "*")
@Log4j2
public class OpcionRespuestaController {

    private final IOpcionRespuestaService iOpcionRespuestaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente la opcion de respuesta", response = OpcionRespuestaDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarOpcionRespuesta(@RequestBody @Validated OpcionRespuestaDTO opcionRespuestaDTO) {
        OpcionRespuestaDTO opcionRespuestaResponse = iOpcionRespuestaService.crearOpcionRespuesta(opcionRespuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarOpcionRespuesta(@RequestBody @Validated OpcionRespuestaDTO opcionRespuestaDTO) {
        OpcionRespuestaDTO opcionRespuestaResponse = iOpcionRespuestaService.actualizarOpcionRespuesta(opcionRespuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarOpcionRespuesta(@RequestParam(value = "idOpcionRespuestaDTO") Integer idOpcionRespuestaDTO ) {
        OpcionRespuestaDTO opcionRespuestaResponse = iOpcionRespuestaService.buscarOpcionRespuesta(idOpcionRespuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarOpcionRespuesta(@RequestBody @Validated OpcionRespuestaDTO opcionRespuestaDTO) {
        String opcionRespuestaResponse = iOpcionRespuestaService.borrarOpcionRespuesta(opcionRespuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(opcionRespuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

