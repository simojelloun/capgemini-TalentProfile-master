package com.capgemini.talentProfile.services.implementations.exceptions;

public class ValidationException extends UnmanagedException {

    public ValidationException(Error error, String message) {
        super(error, message);
    }

    public enum ValidationExceptionError implements Error {

        NOT_VALID_GGID("An error has occured. Please verify the GGID as it might not have the right format.");

        private final String message;

        ValidationExceptionError(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return this.message;
        }
    }


}
