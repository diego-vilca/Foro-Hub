package com.diegovilca.foro.domain.respuesta;

import com.diegovilca.foro.domain.topico.Topico;
import com.diegovilca.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(
            name = "id_topico",
            referencedColumnName = "id")
    private Topico topico;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    @JoinColumn(
            name = "id_autor",
            referencedColumnName = "id")
    private Usuario autor;
    private Boolean esSolucion;

}
