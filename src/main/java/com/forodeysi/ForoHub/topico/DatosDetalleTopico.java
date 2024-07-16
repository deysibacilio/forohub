package com.forodeysi.ForoHub.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estatus status,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                LocalDateTime.parse(topico.getFechaCreacion()),
                Estatus.valueOf(topico.getEstatus().name()),
                String.valueOf(topico.getAutor()),
                String.valueOf(topico.getCurso())
        );
    }
}

