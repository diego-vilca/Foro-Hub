package com.vicv.foro.domain.curso;

public enum Categoria {
    HTML("HTML"),
    JAVA("Java"),
    SPRINGBOOT("Spring Boot 3"),
    SQL("SQL");

    private String descripcion;

    Categoria (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
