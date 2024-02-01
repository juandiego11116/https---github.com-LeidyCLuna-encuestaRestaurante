package com.sura.encuesta.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.encuesta.dto.EncuestaDTO;
import com.sura.encuesta.service.IEncuestaService;
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
@RequestMapping("/encuesta/encuesta")
@CrossOrigin(origins = "*")
@Log4j2
public class EncuestaController {

    private final IEncuestaService iEncuestaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente la encuesta", response = EncuestaDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema de encuestas")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarEncuesta(@RequestBody @Validated EncuestaDTO encuestaDTO) {
        EncuestaDTO encuestaResponse = iEncuestaService.crearEncuesta(encuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarEncuesta(@RequestBody @Validated EncuestaDTO encuestaDTO) {
        EncuestaDTO encuestaResponse = iEncuestaService.actualizarEncuesta(encuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

   /* @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarEncuesta(@RequestParam(value = "idEncuestaDTO") Integer idEncuestaDTO) {
        EncuestaDTO encuestaResponse = iEncuestaService.buscarEncuesta(idEncuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }*/

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarEncuesta(@RequestBody @Validated EncuestaDTO encuestaDTO) {
        String encuestaResponse = iEncuestaService.borrarEncuesta(encuestaDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generarEncuesta(@RequestParam(value = "idEncuestaDTO") Integer idEncuestaDTO) {
        EncuestaDTO encuestaResponse = iEncuestaService.generarEncuesta(idEncuestaDTO);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(encuestaResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


