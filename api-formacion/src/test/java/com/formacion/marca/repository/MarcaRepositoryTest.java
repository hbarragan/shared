package com.formacion.marca.repository;

import com.formacion.CommonRepositoryTest;
import com.formacion.marca.model.entity.Marca;
import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarcaRepositoryTest extends CommonRepositoryTest {

	@Autowired
	private MarcaRepository repository;
	@Autowired
	private MarcaRepositoryCustom repositoryCustom;

	private static Marca marca = new Marca();

	@Before
	public void init() {
		marca = repository.getById(1L);
	}

	@Test
	public void test10_CreateSucces() {
		Marca marca = getMarca();
		Marca result = repository.saveAndFlush(marca);
		marca.setId(result.getId());
		assertAll(() -> assertNotNull(result.getId()),
				() -> assertEquals(marca.getCode(), result.getCode()),
				() -> assertEquals(marca.getDescription(), result.getDescription()));

	}

	@Test
	public void test11_GetByIdSucces() {
		Optional<Marca> result = repository.findById(marca.getId());
		assertAll(() -> assertEquals(marca.getId(), result.get().getId()),
				() -> assertEquals(marca.getCode(), result.get().getCode()),
				() -> assertEquals(marca.getDescription(), result.get().getDescription()));
	}

	@Test
	public void test12_GetAllSucces() {
		MarcaFiltersJson filters = new MarcaFiltersJson();
		filters.setCode(marca.getCode());
		Page<MarcaJson> result = repositoryCustom.findAllByFilter(filters, page);
		assertTrue(result.getContent().size() > 0);
	}

	@Test
	public void test13_UpdateSucces() {
		marca.setCode(marca.getCode() + "Edited");
		marca.setDescription(marca.getDescription() + "Edited");

		repository.saveAndFlush(marca);

		Optional<Marca> result = repository.findById(marca.getId());

		assertAll(() -> assertEquals(marca.getId(), result.get().getId()),
				() -> assertEquals(marca.getCode(), result.get().getCode()),
				() -> assertEquals(marca.getDescription(), result.get().getDescription()));
	}

	@Test(expected = JpaObjectRetrievalFailureException.class)
	public void test14_RemoveSucces() {

		Marca marca = repository.saveAndFlush(getMarca());
		Marca result = repository.getById(marca.getId());

		assertAll(() -> assertEquals(marca.getId(), result.getId()),
				() -> assertEquals(marca.getCode(), result.getCode()),
				() -> assertEquals(marca.getDescription(), result.getDescription()));

		repository.deleteById(marca.getId());
		repository.getById(marca.getId());
	}

	private Marca getMarca() {
		return new Marca("MR1", "Marca 1");
	}

}
