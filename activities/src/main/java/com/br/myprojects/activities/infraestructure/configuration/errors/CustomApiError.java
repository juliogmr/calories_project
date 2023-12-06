package com.br.myprojects.activities.infraestructure.configuration.errors;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomApiError {
    private String timestamp;
    private int status;
    private String error;
    private String path;

    public CustomApiError(HttpError httpError, String path) {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.status = httpError.getStatusCode();
        this.error = httpError.getMessage();
        this.path = path;
    }
}