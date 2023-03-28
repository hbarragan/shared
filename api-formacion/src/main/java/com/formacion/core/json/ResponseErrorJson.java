package com.formacion.core.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseErrorJson {
    private StackTraceElement[] stackTrace;
    private LocalDateTime timestamp;

}

