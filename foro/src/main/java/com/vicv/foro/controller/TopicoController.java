package com.vicv.foro.controller;

import com.vicv.foro.domain.topico.DatosRegistroTopico;
import com.vicv.foro.domain.topico.DatosRespuestaTopico;
import com.vicv.foro.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                                                UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaTopico datosRespuestaTopico = topicoService.guardarTopico(datos);
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(datosRespuestaTopico.id()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
