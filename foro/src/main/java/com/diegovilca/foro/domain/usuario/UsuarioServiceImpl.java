package com.diegovilca.foro.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DatosResponseUsuario guardarUsuario(DatosRegistroUsuario datos) {
        DatosRegistroUsuario datosRegistrados;

        //si el rol del usuario es null asigno por defecto el rol USUARIO
        if (datos.rol() == null){
            datosRegistrados = new DatosRegistroUsuario(datos.nombre(), datos.correoElectronico(), passwordEncoder.encode(datos.contrasenia()));
        }else{
            datosRegistrados = new DatosRegistroUsuario(datos.nombre(), datos.correoElectronico(), passwordEncoder.encode(datos.contrasenia()), datos.rol());
        }

        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistrados));
        return new DatosResponseUsuario(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getRol());
    }


}
