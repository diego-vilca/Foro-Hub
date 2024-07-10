package com.vicv.foro.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public DatosResponseUsuario guardarUsuario(DatosRegistroUsuario datos) {
        DatosRegistroUsuario datosRegistrados;

        //si el rol del usuario es null asigno por defecto el rol USUARIO
        if (datos.rol() == null){
            datosRegistrados = new DatosRegistroUsuario(datos.nombre(), datos.correoElectronico(), datos.contrasenia());
        }else{
            datosRegistrados = datos;
        }

        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistrados));
        return new DatosResponseUsuario(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getRol());
    }
}
