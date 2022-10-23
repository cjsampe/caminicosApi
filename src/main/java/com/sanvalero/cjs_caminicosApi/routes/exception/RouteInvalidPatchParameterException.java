package com.sanvalero.cjs_caminicosApi.routes.exception;

public class RouteInvalidPatchParameterException extends RuntimeException {

    public RouteInvalidPatchParameterException(){
        super();
    }

    public RouteInvalidPatchParameterException(String Key){
        super(String.format("Parámetro '%s' para actualizar la ruta desconocido"));
    }
}
