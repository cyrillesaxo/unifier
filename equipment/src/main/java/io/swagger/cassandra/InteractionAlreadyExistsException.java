package io.swagger.cassandra;

public class InteractionAlreadyExistsException extends RuntimeException{
    public InteractionAlreadyExistsException (String message) {
        super(message);
    }
}
