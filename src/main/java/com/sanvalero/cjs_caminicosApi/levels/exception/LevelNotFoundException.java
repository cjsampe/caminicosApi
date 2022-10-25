package com.sanvalero.cjs_caminicosApi.levels.exception;

public class LevelNotFoundException extends RuntimeException {

    public LevelNotFoundException(){
        super();
    }

    public LevelNotFoundException(String message){
        super(message);

    }

    public LevelNotFoundException(long id){
        super("Error al buscar la información de este post por el ID: " + id);
    }
}
