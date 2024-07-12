package com.vicv.foro.controller;

import com.vicv.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<DatosResponseTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                                               UriComponentsBuilder uriComponentsBuilder){
        DatosResponseTopico datosResponseTopico = topicoService.guardarTopico(datos);
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(datosResponseTopico.id()).toUri();

        return ResponseEntity.created(url).body(datosResponseTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion){
        return ResponseEntity.ok(topicoService.listarTopicos(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosResponseTopico> obtenerTopico(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.obtenerTopico(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosResponseTopico> modificarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){
        return ResponseEntity.ok(topicoService.editarTopico(id, datos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);

        return ResponseEntity.noContent().build();
    }


}
