package com.vicv.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        String contrasenia,
        Rol rol
) {
        public DatosRegistroUsuario(String nombre, String correoElectronico, String contrasenia){
                this(nombre, correoElectronico, contrasenia, Rol.USUARIO);
        }
}
