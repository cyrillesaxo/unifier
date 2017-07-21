package io.swagger.cassandra;

public class InteractionNotFoundException extends RuntimeException{
    public InteractionNotFoundException(String message) {
        super(message);
    }
}
