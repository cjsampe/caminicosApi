package com.sanvalero.cjs_caminicosApi.post.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(){
        super();
    }

    public PostNotFoundException(String message){
        super(message);

    }

    public PostNotFoundException(long id){
        super("Error al buscar la información de este post por el ID: " + id);
    }
}
