package com.formacion.core.json;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AuditableJson implements Serializable {
	private LocalDateTime dataCreacio;
	private LocalDateTime dataModificacio;
	private String usuariCreacio;
	private String usuariModificacio;
}
