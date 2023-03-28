package com.formacion.marca.service;


import com.formacion.CommonServiceTest;
import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import com.formacion.marca.services.MarcaService;
import com.formacion.marca.services.impl.MarcaServiceImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@Import(MarcaServiceImpl.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarcaServiceTest extends CommonServiceTest {

	@Autowired
	private MarcaService service;

	MarcaJson marca = new MarcaJson();

	@Before
	public void init() {
		marca = service.getById(1L);
	}

	@Test
	public void test10_GetAllSucces() throws Exception {

		MarcaFiltersJson filters = new MarcaFiltersJson();
		Page<MarcaJson> resultWithOutFilters = service.getAll(filters, this.getPageable("code", "DESC"));
		filters.setCode(marca.getCode());
		Page<MarcaJson> resultWithFilters = service.getAll(filters, this.getPageable("code", "DESC"));

		assertAll(() -> assertNotNull(resultWithOutFilters), () -> assertNotNull(resultWithFilters),
				() -> assertNotEquals(resultWithOutFilters.getTotalElements(), resultWithFilters.getTotalElements()));
	}

	@Test
	public void test11_GetByIdSucces() throws Exception {

		MarcaJson result = service.getById(marca.getId());

		assertAll(() -> assertNotNull(result.getId()),
				() -> assertEquals(result.getCode(), marca.getCode()),
				() -> assertEquals(result.getDescription(), marca.getDescription()));
	}

	@Test
	public void test12_CreateSucces() throws Exception {

		marca.setId(null);
		MarcaJson result = service.create(marca);

		assertAll(() -> assertNotNull(result.getId()),
				() -> assertEquals(marca.getCode(), result.getCode()),
				() -> assertEquals(marca.getDescription(), result.getDescription()));

		marca = result;
	}

	@Test
	public void test13_UpdateSucces() throws Exception {

		marca.setCode(marca.getCode() + "Edited");
		marca.setDescription(marca.getDescription() + "Edited");
		MarcaJson result = service.update(marca);
		assertAll(() -> assertEquals(result.getId(), marca.getId()),
				() -> assertEquals(result.getCode(), marca.getCode()),
				() -> assertEquals(result.getDescription(), marca.getDescription()),
				() -> assertNotNull(result.getDataModificacio())
		);
	}

	@Test(expected = EntityNotFoundException.class)
	public void test14_RemoveSucces() throws Exception {

		// Create marca
		marca.setId(null);
		MarcaJson result = service.create(marca);

		// Delete marca
		service.remove(result.getId());

		// Get marca
		service.getById(result.getId());
	}

	@Test(expected = EntityNotFoundException.class)
	public void test15_RemoveListSucces() throws Exception {

		// Creacio equipament
		marca.setId(null);
		MarcaJson result = service.create(marca);

		List<Long> ids = new ArrayList<Long>();
		ids.add(result.getId());

		// Eliminacio equipament
		service.remove(ids);

		// Recuperar
		service.getById(result.getId());
	}

	@Test(expected = EntityNotFoundException.class)
	public void test16_GetByIdError() throws Exception {
		service.getById(99999L);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void test17_CreateError() throws Exception {
		service.create(new MarcaJson());
	}

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void test18_UpdateError() throws Exception {

		marca.setId(null);
		service.update(marca);

	}

	@Test(expected = EntityNotFoundException.class)
	public void test19_RemoveError() throws Exception {
		service.remove(99999L);
	}

}
