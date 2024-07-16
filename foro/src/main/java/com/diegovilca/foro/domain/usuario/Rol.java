package com.diegovilca.foro.domain.usuario;

public enum Rol {
    ADMINISTRADOR("Administrador"),
    MODERADOR("Moderador"),
    USUARIO("Usuario");

    private String descripcion;

    Rol (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
