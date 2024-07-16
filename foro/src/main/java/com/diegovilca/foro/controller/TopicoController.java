package com.diegovilca.foro.controller;

import com.diegovilca.foro.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import java.util.Map;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name = "bearer-key")
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
    public ResponseEntity<DatosResponseTopico> modificarTopico(@PathVariable Long id, @RequestBody Map<String, Object> payload){
        return ResponseEntity.ok(topicoService.editarTopico(id, payload));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);

        return ResponseEntity.noContent().build();
    }


}
