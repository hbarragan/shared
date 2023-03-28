package com.formacion.marca.repository;

import com.formacion.marca.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="producto")
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
