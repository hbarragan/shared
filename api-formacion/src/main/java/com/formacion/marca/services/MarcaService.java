package com.formacion.marca.services;

import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MarcaService {

	/**
	 * Mètode per obtenir un marca pel seu identificador
	 * 
	 * @param id
	 * @return marca
	 */
	MarcaJson getById(Long id);

	/**
	 * Mètode per obtenir llistat d'marcas per filtre
	 *
	 * @param filtres
	 * @param pageable
	 * @return
	 */
	Page<MarcaJson> getAll(MarcaFiltersJson filter, Pageable pageable);

	/**
	 * Mètode per modificar marca
	 *
	 * @param marcaJson
	 * @return Long
	 */
	MarcaJson create(MarcaJson marcaJson);

	/**
	 * Mètode per modificar marca
	 *
	 * @param marcaJson
	 */
	MarcaJson update(MarcaJson marcaJson);

	/**
	 * Mètode per eliminar marca per identificador
	 *
	 * @param id
	 */
	void remove(Long id);

	/**
	 * Mètode per eliminar marca per llistat identificadors
	 *
	 * @param ids
	 */
	void remove(List<Long> ids);
}
