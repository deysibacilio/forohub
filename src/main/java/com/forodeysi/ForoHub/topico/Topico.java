package com.forodeysi.ForoHub.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name="topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    private Long autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.activo = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now().format(formatter);
        this.estatus = Estatus.ABIERTO;
        this.autor = datosRegistroTopico.autor();
        this.curso = Curso.valueOf(String.valueOf(datosRegistroTopico.curso()));
    }

    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.estatus() != null){
            this.estatus = Estatus.valueOf(datosActualizarTopico.estatus());
        }
        if (datosActualizarTopico.curso() != null){
            this.curso = Curso.valueOf(datosActualizarTopico.curso());
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
