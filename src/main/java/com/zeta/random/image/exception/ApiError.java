package com.zeta.random.image.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiError {
    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Getter
    private HttpStatus status;
    @Getter
    private String message;
    @Getter
    private String errorCode;

    ApiError(String message, String errorCode) {
        status = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.errorCode = errorCode;
    }

    ApiError(HttpStatus status, String message, String errorCode) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }
}
