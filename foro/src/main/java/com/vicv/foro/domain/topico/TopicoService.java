package com.vicv.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TopicoService {
    DatosResponseTopico guardarTopico(DatosRegistroTopico dato);
    Page<DatosListadoTopico> listarTopicos(Pageable paginacion);
    DatosResponseTopico obtenerTopico(Long id);
    DatosResponseTopico editarTopico(Long id, DatosActualizarTopico datos);
    void eliminarTopico(Long id);
}
