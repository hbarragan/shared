package com.inditex.zara.engine.data.repository;

import com.inditex.zara.engine.data.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long>
{
}
