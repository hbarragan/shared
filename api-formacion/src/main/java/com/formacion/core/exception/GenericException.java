package com.formacion.core.exception;

import com.formacion.core.exception.enumerator.TypeView;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {
    private final HttpStatus status;
    private final TypeView typeView;

    public GenericException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.typeView = TypeView.NONE;
    }

    public GenericException(HttpStatus status, String message, TypeView typeView) {
        super(message);
        this.status = status;
        this.typeView = typeView;
    }

    public GenericException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.typeView = TypeView.NONE;
    }

    public GenericException(HttpStatus status, String message, Throwable cause, TypeView typeView) {
        super(message, cause);
        this.status = status;
        this.typeView = typeView;
    }

}
