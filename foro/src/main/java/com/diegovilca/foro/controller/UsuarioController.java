package com.diegovilca.foro.controller;

import com.diegovilca.foro.domain.usuario.DatosRegistroUsuario;
import com.diegovilca.foro.domain.usuario.UsuarioService;
import com.diegovilca.foro.domain.usuario.DatosResponseUsuario;
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
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
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
