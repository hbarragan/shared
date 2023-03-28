package com.formacion.marca.model.json;

import com.formacion.core.json.AuditableJson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaJson extends AuditableJson implements Serializable {
	private static final long serialVersionUID = 7910941205358660935L;
	private Long id;
	private String code;
	private String description;
}