package com.vicv.foro.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public DatosResponseUsuario guardarUsuario(DatosRegistroUsuario datos) {
        Usuario usuario = usuarioRepository.save(new Usuario(datos));
        return new DatosResponseUsuario(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getRol());
    }
}
