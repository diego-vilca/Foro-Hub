package com.vicv.foro.domain.topico;

import com.vicv.foro.domain.curso.CursoRepository;
import com.vicv.foro.domain.topico.validaciones.ValidadorDeTopicos;
import com.vicv.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoServiceImpl implements TopicoService{
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private List<ValidadorDeTopicos> validadores;

    @Override
    public DatosResponseTopico guardarTopico(DatosRegistroTopico datos) {

        validadores.forEach(v -> v.validar(datos));

        Topico topico = topicoRepository.save(new Topico(
                null,
                datos.titulo(),
                datos.mensaje(),
                LocalDateTime.now(),
                Status.ABIERTO,
                usuarioRepository.findById(datos.idAutor()).get(),
                cursoRepository.findByNombre(datos.nombreCurso()).get(),
                null
        ));

        return new DatosResponseTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
