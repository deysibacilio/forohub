package com.forodeysi.ForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
        @NotNull(message = "El campo Autor es requerido")
        Long autor,
        @NotBlank(message = "El campo titulo es requerido")
        String titulo,
        @NotBlank(message = "El campo mensaje es requerido")
        String mensaje,
        @NotNull(message = "El campo curso es requerido")
        Curso curso) {
}

