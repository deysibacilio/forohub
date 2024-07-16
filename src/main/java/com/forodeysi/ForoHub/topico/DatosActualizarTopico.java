package com.forodeysi.ForoHub.topico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotEmpty String titulo,
        @NotEmpty String mensaje,
        @NotEmpty String estatus,
        @NotEmpty String curso
) {
}
