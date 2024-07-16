package com.diegovilca.foro.domain.respuesta;

import java.time.LocalDateTime;

public record DatosResponseRespuesta(
        Long id,
        String mensaje,
        Long idTopico,
        Long idUsuario,
        LocalDateTime fechaCreacion
) {
}
