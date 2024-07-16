package com.forodeysi.ForoHub.controller;

import com.forodeysi.ForoHub.infra.seguridad.AutenticacionService;
import com.forodeysi.ForoHub.usuarios.DatosAutenticarUsuario;
import com.forodeysi.ForoHub.usuarios.Usuario;
import com.forodeysi.ForoHub.infra.seguridad.DatosJWTToken;
import com.forodeysi.ForoHub.infra.seguridad.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacionController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticarUsuario datosAutenticarUsuario){
        try {
            Authentication authToken = new UsernamePasswordAuthenticationToken(
                    datosAutenticarUsuario.login(),
                    datosAutenticarUsuario.clave());

            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();
            var JWTtoken = tokenService.generarToken(usuario);
            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Error durante la autenticación: " + e.getMessage());
        }
    }
}
