package com.diegovilca.foro.domain.topico.validaciones;

import com.diegovilca.foro.domain.topico.TopicoRepository;
import com.diegovilca.foro.domain.topico.DatosRegistroTopico;
import com.diegovilca.foro.domain.topico.Topico;
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
