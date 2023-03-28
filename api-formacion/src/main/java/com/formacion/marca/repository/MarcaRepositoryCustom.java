package com.formacion.marca.repository;

import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarcaRepositoryCustom {
    /**
     * @param filtres Filtres de la cerca
     * @param pag     Informació de paginació
     * @return Page Llistat amb els equipaments que compleixen amb els filtres
     */
    public Page<MarcaJson> findAllByFilter(MarcaFiltersJson filtres, Pageable pag);
}
