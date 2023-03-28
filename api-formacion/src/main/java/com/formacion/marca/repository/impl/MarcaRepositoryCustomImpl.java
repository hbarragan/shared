package com.formacion.marca.repository.impl;


import com.formacion.core.repository.AbstractRepositoryPaginator;
import com.formacion.marca.mapper.MarcaMapper;
import com.formacion.marca.model.entity.Marca;
import com.formacion.marca.model.entity.QMarca;
import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import com.formacion.marca.repository.MarcaRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MarcaRepositoryCustomImpl extends AbstractRepositoryPaginator implements MarcaRepositoryCustom {

	private static final QMarca Q_MARCA = QMarca.marca;

	public MarcaRepositoryCustomImpl() {
		super(MarcaRepositoryCustomImpl.class);
	}

	@Override
	public Page<MarcaJson> findAllByFilter(MarcaFiltersJson filtres, Pageable pageable) {

		JPQLQuery<Marca> query = from(Q_MARCA);

		applyFilter(filtres, query);
		applyPagination(pageable, query);
		applySorting(pageable, query, Q_MARCA.toString());

		List<Marca> result = query.fetch();
		return new PageImpl<>(MarcaMapper.INSTANCE.convertByEntity(result), pageable, query.fetchCount());

	}

	private void applyFilter(MarcaFiltersJson filtres, JPQLQuery<?> query) {

		BooleanBuilder builder = new BooleanBuilder();

		if (filtres != null) {
			Optional.ofNullable(filtres.getCode()).ifPresent(code -> {
				builder.and(Q_MARCA.code.containsIgnoreCase(filtres.getCode()));
			});
			Optional.ofNullable(filtres.getDescription()).ifPresent(description -> {
				builder.and(Q_MARCA.description.containsIgnoreCase(filtres.getDescription()));
			});
		}
		query.where(builder);
	}

}
