package com.diegovilca.foro.domain.topico;

import java.time.LocalDateTime;

public record  DatosListadoTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    Status estado,
    Long idAutor,
    String nombreCurso

) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor().getId(), topico.getCurso().getNombre());
    }
}
