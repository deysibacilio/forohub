package com.forodeysi.ForoHub.usuarios;

// Definición de la clase DatosRegistroUsuario
public class DatosRegistroUsuario {
    private String login;
    private String clave;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;

    // Métodos getter
    public String getLogin() {
        return this.login;
    }

    public String getClave() {
        return this.clave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRol() {
        return this.rol;
    }

    // Métodos setter
    public void setLogin(String login) {
        this.login = login;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
