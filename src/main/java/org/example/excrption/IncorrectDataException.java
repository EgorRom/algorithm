package org.example.excrption;

public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message) {
        super(message);
    }
}
