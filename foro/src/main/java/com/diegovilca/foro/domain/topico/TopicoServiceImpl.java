package com.diegovilca.foro.domain.topico;

import com.diegovilca.foro.domain.curso.CursoRepository;
import com.diegovilca.foro.domain.topico.validaciones.ValidadorDeTopicos;
import com.diegovilca.foro.domain.usuario.UsuarioRepository;
import com.diegovilca.foro.infra.ValidacionDeIntegridad;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Autowired
    private ObjectMapper objectMapper;

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
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con este id"));

        return new DatosResponseTopico(topico);
    }

    @Override
    public DatosResponseTopico editarTopico(Long id, Map<String, Object> payload) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con este id"));

        // Convertir el payload a un ObjectNode para verificar los campos
        ObjectNode objectNode = objectMapper.convertValue(payload, ObjectNode.class);

        // Validar que el payload contiene al menos uno de los campos permitidos
        if (!objectNode.has("titulo") && !objectNode.has("mensaje")) {
            throw new ValidacionDeIntegridad("Debe proporcionar al menos un campo para actualizar");
        }

        // Validar que el payload no contiene campos no permitidos
        Set<String> validFields = Set.of("titulo", "mensaje");
        Iterator<String> fieldNames = objectNode.fieldNames();
        while (fieldNames.hasNext()) {
            String field = fieldNames.next();
            if (!validFields.contains(field)) {
                throw new ValidacionDeIntegridad("Campo no permitido: " + field);
            }
        }

        // Convertir el payload al record DatosActualizarTopico
        DatosActualizarTopico datos = objectMapper.convertValue(objectNode, DatosActualizarTopico.class);



        topico.actualizarDatos(datos);
        return new DatosResponseTopico(topico);
    }

    @Override
    public void eliminarTopico(Long id) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new ValidacionDeIntegridad("No se encontro topico con este id"));
        topico.desactivarTopico();
    }


}
