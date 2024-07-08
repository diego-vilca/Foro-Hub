package com.vicv.foro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotNull
        Nombre nombre
) {
}
