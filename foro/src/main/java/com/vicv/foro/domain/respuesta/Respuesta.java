package com.vicv.foro.domain.respuesta;

import com.vicv.foro.domain.topico.Topico;
import com.vicv.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;

public class Respuesta {
    private Long id;
    private String mensaje;
    private Topico topico;
    private LocalDateTime fechaCreacion;
    private Usuario autor;
    private Boolean solucion;
}
