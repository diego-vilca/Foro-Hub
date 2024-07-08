package com.vicv.foro.domain.usuario;

public record DatosResponseUsuario(
        Long id,
        String nombre,
        String correoelectronico,
        Rol rol
) {
}
