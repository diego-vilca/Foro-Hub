package com.vicv.foro.domain.usuario;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String correoelectronico,
        Rol rol
) {
}
