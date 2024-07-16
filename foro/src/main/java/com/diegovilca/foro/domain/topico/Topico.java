package com.diegovilca.foro.domain.topico;

import com.diegovilca.foro.domain.respuesta.Respuesta;
import com.diegovilca.foro.domain.curso.Curso;
import com.diegovilca.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ABIERTO;
    @ManyToOne
    @JoinColumn(
            name = "id_autor",
            referencedColumnName = "id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(
            name = "id_curso",
            referencedColumnName = "id")
    private Curso curso;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "topico")
    private List<Respuesta> respuestas;
    private Boolean activo = true;

    public Topico(String titulo, String mensaje, Usuario usuario, Curso curso){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = usuario;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
    }


    public void desactivarTopico() {
        this.activo = false;
    }
}


