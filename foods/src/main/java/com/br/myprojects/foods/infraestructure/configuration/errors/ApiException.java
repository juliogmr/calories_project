package com.br.myprojects.foods.infraestructure.configuration.errors;

public class ApiException extends RuntimeException {
    private final CustomApiError customApiError;

    public ApiException(CustomApiError customApiError) {
        super(customApiError.getError());
        this.customApiError = customApiError;
    }

    public ApiException(String message, CustomApiError customApiError) {
        super(message);
        this.customApiError = customApiError;
    }

    public CustomApiError getCustomApiError() {
        return customApiError;
    }
}

