package com.formacion.marca.endpoints;


import com.formacion.CommonControllerTest;
import com.formacion.core.util.MessageConstants;
import com.formacion.marca.model.json.MarcaJson;
import com.formacion.marca.services.MarcaService;
import com.formacion.util.UrlConstants;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Import(MarcaController.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarcaControllerTest extends CommonControllerTest {

	@Autowired
	private MarcaService service;

	MarcaJson marca = new MarcaJson();

	@Before
	public void init() {
		marca = service.getById(1L);
	}

	@Test
	public void test10_Create() throws Exception {
		executeSucces(post(UrlConstants.MARCA), objectMapper.writeValueAsString(
				new MarcaJson(null, marca.getCode(), marca.getDescription())));
	}

	@Test
	public void test11_GetById() throws Exception {
		executeSucces(get(UrlConstants.MARCA + UrlConstants.SLASH  + marca.getId()), "");
	}

	@Test
	public void test12_Update() throws Exception {
		marca.setCode(marca.getCode() + "Edited");
		marca.setDescription(marca.getDescription() + "Edited");
		executeSucces(put(UrlConstants.MARCA + UrlConstants.SLASH + marca.getId()),
				objectMapper.writeValueAsString(marca));
	}

	@Test
	public void test13_Remove() throws Exception {
		marca.setId(null);
		MarcaJson result = service.create(marca);
		executeSucces(delete(UrlConstants.MARCA + UrlConstants.SLASH + result.getId()), "");
	}

	@Test
	public void test14_RemoveList() throws Exception {

		marca.setId(null);
		MarcaJson result = service.create(marca);

		List<Long> ids = Arrays.asList(result.getId());
		executeSucces(delete(UrlConstants.MARCA), objectMapper.writeValueAsString(ids));
	}

	@Test
	public void test16_GetByIdError() throws Exception {
		executeError(get(UrlConstants.MARCA + "/99999"), "", MessageConstants.ENTITY_NOT_FOUND);
	}

	@Test
	public void test17_CreateError() throws Exception {
		executeError(post(UrlConstants.MARCA), objectMapper.writeValueAsString(new MarcaJson()),
				MessageConstants.COULD_NOT_EXECUTE_STATEMENT);
	}

	@Test
	public void test18_UpdateError() throws Exception {
		LocalDateTime yesterday =LocalDateTime.now().minusDays(1);
		marca.setDataModificacio(yesterday);
		executeError(put(UrlConstants.MARCA + "/0"), objectMapper.writeValueAsString(marca),
				MessageConstants.UPDATE_ENTITY_OTHER_USER);
	}

	@Test
	public void test19_RemoveError() throws Exception {
		executeError(delete(UrlConstants.MARCA + "/99999"), "", MessageConstants.ENTITY_NOT_FOUND);
	}

}
