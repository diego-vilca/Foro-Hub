package com.vicv.foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroRespuesta(
        @NotBlank
        Long idUsuario,
        @NotBlank
        Long idTopico,
        @NotBlank
        String mensaje
) {
}
