package com.sebrae.desafio.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorMessages(
        LocalDateTime timestamp,
        int statusCode,
        List<String> descriptions,
        String message
) {
    public ErrorMessages(int statusCode, List<String> descriptions, String message) {
        this(
                LocalDateTime.now(),
                statusCode,
                descriptions,
                message
        );
    }
}
