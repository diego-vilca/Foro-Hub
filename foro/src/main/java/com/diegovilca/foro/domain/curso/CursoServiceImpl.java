package com.diegovilca.foro.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public DatosResponseCurso guardarCurso(DatosRegistroCurso datos) {
        Curso curso = cursoRepository.save(new Curso(datos));

        return new DatosResponseCurso(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
