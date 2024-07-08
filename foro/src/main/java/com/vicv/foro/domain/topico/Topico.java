package com.vicv.foro.domain.topico;

import com.vicv.foro.domain.curso.Curso;
import com.vicv.foro.domain.respuesta.Respuesta;
import com.vicv.foro.domain.usuario.Usuario;
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
    private Status status;
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
}


