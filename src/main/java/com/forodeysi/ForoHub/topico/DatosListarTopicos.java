package com.forodeysi.ForoHub.topico;

public record DatosListarTopicos(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String estatus,
        Long autor,
        String curso) {

    public DatosListarTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstatus().toString(), topico.getAutor(), topico.getCurso().toString());
    }
}