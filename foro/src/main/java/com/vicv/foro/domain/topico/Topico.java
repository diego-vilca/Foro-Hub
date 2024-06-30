package com.vicv.foro.domain.topico;

import com.vicv.foro.domain.curso.Curso;
import com.vicv.foro.domain.respuesta.Respuesta;
import com.vicv.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;


public class Topico {
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Status status;
    private Usuario autor;
    private Curso curso;
    private List<Respuesta> respuestas;
}
