package com.vicv.foro.controller;

import com.vicv.foro.domain.curso.CursoService;
import com.vicv.foro.domain.curso.DatosRegistroCurso;
import com.vicv.foro.domain.curso.DatosResponseCurso;
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
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosResponseCurso> registrarCurso (@RequestBody @Valid DatosRegistroCurso datos,
                                                              UriComponentsBuilder uriComponentsBuilder){
        DatosResponseCurso datosResponseCurso = cursoService.guardarCurso(datos);
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(datosResponseCurso.id()).toUri();

        return ResponseEntity.created(url).body(datosResponseCurso);
    }
}
