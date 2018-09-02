package com.capgemini.talentProfile.services.implementations.exceptions;

import lombok.Getter;

public abstract class UnmanagedException extends RuntimeException {
    @Getter
    private final Error error;

    @Getter
    private final String code;

    public UnmanagedException(Error error) {
        super(error.getMessage());
        this.error = error;
        this.code = error.name();
    }

    public UnmanagedException(Error error, String message) {
        super(message);
        this.error = error;
        this.code = error.name();
    }

    public UnmanagedException(Error error, Throwable cause) {
        super(cause);
        this.error = error;
        this.code = error.name();
    }

    public UnmanagedException(Error error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
        this.code = error.name();
    }
}
