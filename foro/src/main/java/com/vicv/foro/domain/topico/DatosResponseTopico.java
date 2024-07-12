package com.vicv.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosResponseTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha
) {
    public DatosResponseTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
