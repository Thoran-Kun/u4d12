package org.example.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Object id) {

        super("Il record con id " + id + " non è stato trovato!");
    }
}
