package com.forodeysi.ForoHub.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {

    public ValidacionDeIntegridad(String mensaje) {
        super(mensaje);
    }
}

