package com.vicv.foro.domain.topico;

import com.vicv.foro.domain.curso.CursoRepository;
import com.vicv.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoServiceImpl implements TopicoService{
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public DatosResponseTopico guardarTopico(DatosRegistroTopico dato) {
        Topico topico = topicoRepository.save(new Topico(
                null,
                dato.titulo(),
                dato.mensaje(),
                LocalDateTime.now(),
                Status.ABIERTO,
                usuarioRepository.findById(dato.idAutor()).get(),
                cursoRepository.findByNombre(dato.nombreCurso()).get(),
                null
        ));

        return new DatosResponseTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
