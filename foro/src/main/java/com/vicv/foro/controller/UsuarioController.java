package com.vicv.foro.controller;

import com.vicv.foro.domain.usuario.DatosRegistroUsuario;
import com.vicv.foro.domain.usuario.DatosResponseUsuario;
import com.vicv.foro.domain.usuario.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosResponseUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario dato,
                                                                 UriComponentsBuilder uriComponentsBuilder){
        DatosResponseUsuario datosResponseUsuario = usuarioService.guardarUsuario(dato);
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(datosResponseUsuario.id()).toUri();

        return ResponseEntity.created(url).body(datosResponseUsuario);
    }
}
