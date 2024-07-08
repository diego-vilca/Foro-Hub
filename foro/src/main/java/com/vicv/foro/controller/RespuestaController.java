package com.vicv.foro.controller;

import com.vicv.foro.domain.respuesta.DatosRegistroRespuesta;
import com.vicv.foro.domain.respuesta.DatosResponseRespuesta;
import com.vicv.foro.domain.respuesta.RespuestaService;
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
