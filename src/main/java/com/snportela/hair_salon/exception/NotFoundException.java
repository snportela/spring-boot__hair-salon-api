package com.snportela.hair_salon.exception;

public class NotFoundException extends BusinessException {

    public NotFoundException() { super("Resource not found."); }
}
