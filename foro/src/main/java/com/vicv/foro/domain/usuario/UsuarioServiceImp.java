package com.vicv.foro.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public DatosRespuestaUsuario guardarUsuario(DatosRegistroUsuario datos) {
        Usuario usuario = usuarioRepository.save(new Usuario(datos));
        return new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getRol());
    }
}
