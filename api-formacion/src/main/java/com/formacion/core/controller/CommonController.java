package com.formacion.core.controller;

import com.formacion.core.service.CommonUtils;
import com.formacion.core.util.MessageConstants;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.inject.Inject;

@ApiResponses(value = { @ApiResponse(responseCode = "200", description = MessageConstants.SUCCES),
		@ApiResponse(responseCode = "500", description = MessageConstants.ENTITY_NOT_FOUND),
		@ApiResponse(responseCode = "500", description = MessageConstants.ILLEGAL_ARGUMENT),
		@ApiResponse(responseCode = "500", description = MessageConstants.UPDATE_ENTITY_OTHER_USER),
		@ApiResponse(responseCode = "403", description = MessageConstants.FORBIDDEN),
		@ApiResponse(responseCode = "401", description = MessageConstants.UNAUTHORIZED) })
public class CommonController {

	@Inject
	protected CommonUtils commonUtils;

}
