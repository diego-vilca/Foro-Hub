package com.vicv.foro.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroTopico(
        @NotNull(message = "El autor es obligatorio y no debe estar vacío")
        @Positive(message = "El id debe ser mayor a cero")
        Long idAutor,
        @NotBlank(message = "El titulo es obligatorio y no debe estar vacío")
        String titulo,
        @NotBlank(message = "El mensaje es obligatorio y no debe estar vacío")
        String mensaje,
        @NotBlank(message = "El nombre del curso es obligatorio y no debe estar vacío")
        String nombreCurso) {
}
