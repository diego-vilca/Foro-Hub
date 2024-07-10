package com.vicv.foro.domain.topico.validaciones;

import com.vicv.foro.domain.topico.DatosRegistroTopico;
import com.vicv.foro.domain.topico.Topico;
import com.vicv.foro.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TopicoDuplicado implements ValidadorDeTopicos{
    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {
        Optional<List<Topico>> listaTopicos = topicoRepository.findByTitulo(datos.titulo());

        Optional<Topico> topicoDuplicado = listaTopicos
                .flatMap(topicos -> topicos.stream()
                        .filter(topico -> datos.mensaje().equals(topico.getMensaje()))
                        .findFirst());

        if (topicoDuplicado.isPresent()){
            throw new ValidationException("No se permite crear topicos duplicados");
        }
    }
}
