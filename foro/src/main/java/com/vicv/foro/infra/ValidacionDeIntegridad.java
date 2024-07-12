package com.vicv.foro.infra;

public class ValidacionDeIntegridad extends RuntimeException{
    public ValidacionDeIntegridad (String mensaje){
        super(mensaje);
    }
}
