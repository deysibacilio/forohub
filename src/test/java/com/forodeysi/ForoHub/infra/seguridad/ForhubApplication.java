package com.forodeysi.ForoHub.infra.seguridad;

import com.forodeysi.ForoHub.topico.Topico;
import com.forodeysi.ForoHub.topico.TopicoRepository;
import com.forodeysi.ForoHub.usuarios.Usuario;
import com.forodeysi.ForoHub.usuarios.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ForhubApplicationTests {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @MockBean
    private Topico mockTopico;

    @MockBean
    private Usuario mockUsuario;

    @Test
    void contextLoads() {
    }

    @Test
    void testTopicoRepository() {
        when(mockTopico.getTitulo()).thenReturn("Título de prueba");
        topicoRepository.save(mockTopico);
        Topico topico = topicoRepository.findByTitulo("Título de prueba");
        assertThat(topico).isNotNull();
        assertThat(topico.getTitulo()).isEqualTo("Título de prueba");
    }

    @Test
    void testUsuarioRepository() {
        when(mockUsuario.getLogin()).thenReturn("usuarioDePrueba");
        usuarioRepository.save(mockUsuario);
        Usuario usuario = (Usuario) usuarioRepository.findByLogin("usuarioDePrueba");
        assertThat(usuario).isNotNull();
        assertThat(usuario.getLogin()).isEqualTo("usuarioDePrueba");
    }
}
