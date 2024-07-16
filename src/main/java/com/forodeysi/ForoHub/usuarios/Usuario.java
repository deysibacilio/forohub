package com.forodeysi.ForoHub.usuarios;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="usuarios")
@Entity(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String login;

    @NotBlank
    private String clave;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String email;

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.login = datosRegistroUsuario.getLogin();
        this.clave = datosRegistroUsuario.getClave();
        this.nombre = datosRegistroUsuario.getNombre();
        this.apellido = datosRegistroUsuario.getApellido();
        this.email = datosRegistroUsuario.getEmail();
        this.activo = true;
        this.rol = Rol.valueOf(datosRegistroUsuario.getRol());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.clave;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.activo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.activo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.activo;
    }

    @Override
    public boolean isEnabled() {
        return this.activo;
    }
}
