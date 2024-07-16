package com.forodeysi.ForoHub.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticarUsuario(
        @NotBlank(message = "El campo login es requerido")
        String login,
        @NotBlank(message = "El campo clave es requerido")
        String clave) {
}
