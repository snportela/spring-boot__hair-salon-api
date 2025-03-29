package com.snportela.hair_salon.exception;

public record ErrorResponse(

        int status,

        String message,

        String details
) {
}
