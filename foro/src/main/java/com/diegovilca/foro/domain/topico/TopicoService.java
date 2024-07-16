package com.diegovilca.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TopicoService {
    DatosResponseTopico guardarTopico(DatosRegistroTopico dato);
    Page<DatosListadoTopico> listarTopicos(Pageable paginacion);
    DatosResponseTopico obtenerTopico(Long id);
    DatosResponseTopico editarTopico(Long id, Map<String, Object> payload);
    void eliminarTopico(Long id);
}
