package com.forodeysi.ForoHub.topico;

import com.forodeysi.ForoHub.infra.errores.ValidacionDeIntegridad;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Topico registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje());
        if (existente.isPresent()) {
            throw new ValidacionDeIntegridad("El tópico con el título '" + datosRegistroTopico.titulo() + "' y el mensaje '" + datosRegistroTopico.mensaje() + "' ya existe.");
        }
        Topico topico = new Topico(datosRegistroTopico);
        return topicoRepository.save(topico);
    }

    public Topico obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionDeIntegridad("No se encontró un tópico con el ID: " + id));
    }

    public Page<DatosListarTopicos> listarTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListarTopicos::new);
    }

    public Topico eliminarTopico(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró un tópico con el ID: " + id));
        topicoRepository.deleteById(id);
        return topico;
    }

    public Topico actualizarTopico(Long id, DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionDeIntegridad("No se encontró un tópico con el ID: " + id));

        topico.actualizarDatos(datosActualizarTopico);
        return topicoRepository.save(topico);
    }
}
