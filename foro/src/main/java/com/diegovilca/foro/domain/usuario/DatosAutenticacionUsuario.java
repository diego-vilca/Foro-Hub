package com.diegovilca.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        String contrasenia
) {
}