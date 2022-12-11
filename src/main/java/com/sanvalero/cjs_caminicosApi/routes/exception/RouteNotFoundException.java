package com.sanvalero.cjs_caminicosApi.routes.exception;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException(){
        super();
    }

    public RouteNotFoundException(String message){
        super(message);

    }

    public RouteNotFoundException(long id){
        super("Error al buscar la información de esta ruta por el ID: " + id);
    }
}
