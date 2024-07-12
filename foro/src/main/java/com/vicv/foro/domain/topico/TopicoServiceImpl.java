package com.vicv.foro.domain.topico;

import com.vicv.foro.domain.curso.CursoRepository;
import com.vicv.foro.domain.topico.validaciones.ValidadorDeTopicos;
import com.vicv.foro.domain.usuario.UsuarioRepository;
import com.vicv.foro.infra.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
                datos.titulo(),
                datos.mensaje(),
                usuarioRepository.findById(datos.idAutor()).get(),
                cursoRepository.findByNombre(datos.nombreCurso()).get()
        ));

        return new DatosResponseTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }

    @Override
    public Page<DatosListadoTopico> listarTopicos(Pageable paginacion) {
        //traigo solo los topicos que se encuentren activos
        Page<DatosListadoTopico> datosListadoTopicos = topicoRepository.findByActivoTrue(paginacion)
                .map(DatosListadoTopico::new);

        return  datosListadoTopicos;
    }

    @Override
    public DatosResponseTopico obtenerTopico(Long id) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con id:" + id));

        return new DatosResponseTopico(topico);
    }

    @Override
    public DatosResponseTopico editarTopico(Long id, DatosActualizarTopico datos) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con id:" + id));
        topico.actualizarDatos(datos);

        return new DatosResponseTopico(topico);
    }

    @Override
    public void eliminarTopico(Long id) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con id:" + id));
        topico.desactivarTopico();
    }


}
