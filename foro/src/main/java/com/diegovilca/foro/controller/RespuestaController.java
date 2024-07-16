package com.diegovilca.foro.controller;

import com.diegovilca.foro.domain.respuesta.DatosRegistroRespuesta;
import com.diegovilca.foro.domain.respuesta.DatosResponseRespuesta;
import com.diegovilca.foro.domain.respuesta.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/respuesta")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosResponseRespuesta> guardarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datos,
                                                                   UriComponentsBuilder uriComponentsBuilder){
        DatosResponseRespuesta datosResponseRespuesta = respuestaService.guardarRespuesta(datos);
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(datosResponseRespuesta.id()).toUri();

        return ResponseEntity.created(url).body(datosResponseRespuesta);
    }
}
