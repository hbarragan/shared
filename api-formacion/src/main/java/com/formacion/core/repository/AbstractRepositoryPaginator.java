package com.formacion.core.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public abstract class AbstractRepositoryPaginator extends QuerydslRepositorySupport {

	protected AbstractRepositoryPaginator(Class<?> domainClass) {
		super(domainClass);
	}

	protected void applyPagination(Pageable pageable, JPQLQuery<?> query) {

		if (pageable != null && pageable.getPageNumber() >= 0 && pageable.getPageSize() > 0) {
			Pageable newPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
			getQuerydsl().applyPagination(newPageable, query);
		}

	}

	protected void applySorting(Pageable pageable, JPQLQuery query, String entity) {
		PathBuilder orderByExpression;

		if (pageable != null && pageable.getSort() != null) {
			for (Sort.Order o : pageable.getSort()) {

				orderByExpression = new PathBuilder(Object.class, entity);

				query.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
						orderByExpression.get(o.getProperty())));
			}
		}

	}
}
