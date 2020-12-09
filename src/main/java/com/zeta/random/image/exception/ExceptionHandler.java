package com.zeta.random.image.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ImageException.class)
    protected ResponseEntity<Object> handleException(
            ImageException ex) {
        ApiError apiError = new ApiError(ImageError.IMAGE_ERROR.getDescritpion(), ImageError.IMAGE_ERROR.getErroCode());
        log.error(UNPROCESSABLE_ENTITY.getReasonPhrase(), ex);
        return buildResponseEntity(apiError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(
            Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ImageError.IMAGE_ERROR.getDescritpion(), ImageError.IMAGE_ERROR.getErroCode());
        log.error(INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
        return buildResponseEntity(apiError);
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
