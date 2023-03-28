package com.formacion.marca.model.json;

import com.formacion.util.FiltersConstants;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MarcaFiltersJson implements Serializable {
	private static final long serialVersionUID = 1L;
	//Format strings
	@Parameter(name = FiltersConstants.CODE, schema = @Schema(type = FiltersConstants.TYPE_STRING), required = false, description = FiltersConstants.CODE)
	private String code;
	@Parameter(name = FiltersConstants.DESCRIPTION, schema = @Schema(type = FiltersConstants.TYPE_STRING), required = false, description = FiltersConstants.DESCRIPTION)
	private String description;
}
