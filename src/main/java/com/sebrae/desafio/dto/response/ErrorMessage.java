package com.sebrae.desafio.dto.response;

import java.time.LocalDateTime;

public record ErrorMessage(
        LocalDateTime timestamp,
        int statusCode,
        String description,
        String message
) {
    public ErrorMessage(int statusCode, String description, String message) {
        this(
                LocalDateTime.now(),
                statusCode,
                description,
                message
        );
    }
}
