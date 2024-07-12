package com.vicv.foro.domain.respuesta;

import com.vicv.foro.domain.topico.TopicoRepository;
import com.vicv.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaServiceImpl implements RespuestaService{
    @Autowired
    RespuestaRepository respuestaRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public DatosResponseRespuesta guardarRespuesta(DatosRegistroRespuesta datos) {
        Respuesta respuesta = respuestaRepository.save(new Respuesta(
                null,
                datos.mensaje(),
                topicoRepository.findByIdAndActivoTrue(datos.idTopico()).get(),
                LocalDateTime.now(),
                usuarioRepository.findById(datos.idAutor()).get(),
                false

        ));

        return new DatosResponseRespuesta(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getId(), respuesta.getAutor().getId(), respuesta.getFechaCreacion());
    }
}
