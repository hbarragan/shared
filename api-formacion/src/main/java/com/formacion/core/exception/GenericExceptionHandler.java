package com.formacion.core.exception;

import com.formacion.core.exception.enumerator.TypeView;
import com.formacion.core.json.ResponseErrorJson;
import com.formacion.core.json.page.ResultJson;
import com.formacion.core.util.MessageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class GenericExceptionHandler {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericExceptionHandler.class);


    /* CUSTOM EXCEPTION ERROR */
    @ExceptionHandler(CustomErrorException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleGenericException(CustomErrorException e, ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), e.getStatus(), e.getMessage(), e.getTypeView(), servletRequest);
    }

    /* INHERITED EXCEPTION ERROR */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleIllegalArgumentException(IllegalArgumentException e,	ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), HttpStatus.BAD_REQUEST, MessageConstants.ILLEGAL_ARGUMENT,
                TypeView.TOAST, servletRequest);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleEntityNotFoundException(EntityNotFoundException e, ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), HttpStatus.NOT_FOUND,
                MessageConstants.ENTITY_NOT_FOUND, TypeView.TOAST, servletRequest);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleAccessDeniedException(AccessDeniedException e, ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), HttpStatus.FORBIDDEN, MessageConstants.FORBIDDEN, TypeView.TOAST, servletRequest);

    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleDateTimeParseException(DateTimeParseException e,	ServletRequest servletRequest) {

        return getResultJsonError(false, e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), TypeView.TOAST, servletRequest);

    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleResponseStatusException(ResponseStatusException e, ServletRequest servletRequest) {

        return getResultJsonError(false, e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), TypeView.TOAST, servletRequest);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleException(Exception e, ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), TypeView.TOAST, servletRequest);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class, InvalidDataAccessApiUsageException.class })
    public ResponseEntity<ResultJson<ResponseErrorJson>> handleDataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest servletRequest) {
        return getResultJsonError(false, e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR,
                MessageConstants.COULD_NOT_EXECUTE_STATEMENT, TypeView.TOAST, servletRequest);
    }

    private ResponseEntity< ResultJson<ResponseErrorJson>> getResultJsonError(boolean success, StackTraceElement[] stackTraceElements,
                                                                              HttpStatus httpStatus, String message, TypeView typeView, ServletRequest servletRequest) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        LOGGER.error(MessageConstants.ERROR_MSG, MessageConstants.IDENTIFICADOR_API, request.getMethod(),
                request.getRequestURI(), httpStatus.value(), message);

        ResponseErrorJson error = new ResponseErrorJson(stackTraceElements, LocalDateTime.now());

        return new ResponseEntity<>(new ResultJson<ResponseErrorJson>(success, httpStatus.value(), message, error, typeView.getValue()), httpStatus);
    }

}

