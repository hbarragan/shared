package com.formacion.core.exception;

import com.formacion.core.exception.enumerator.TypeView;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomErrorException extends RuntimeException {

    private static final long serialVersionUID = 1030631227711760504L;

    private final HttpStatus status;
    private final TypeView typeView;

    public CustomErrorException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.typeView = TypeView.NONE;
    }

    public CustomErrorException(HttpStatus status, String message, TypeView typeView) {
        super(message);
        this.status = status;
        this.typeView = typeView;
    }

    public CustomErrorException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.typeView = TypeView.NONE;
    }

    public CustomErrorException(HttpStatus status, String message, Throwable cause, TypeView typeView) {
        super(message, cause);
        this.status = status;
        this.typeView = typeView;
    }
}

