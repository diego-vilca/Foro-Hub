package com.diegovilca.foro.infra;

public class ValidacionDeIntegridad extends RuntimeException{
    public ValidacionDeIntegridad (String mensaje){
        super(mensaje);
    }
}
