package com.inditex.zara.engine.data.repository;

import com.inditex.zara.engine.data.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PricesRepository extends JpaRepository<Prices, Long>
{
	@Query("FROM Prices p WHERE p.brand.id =:brandId and p.productId =:productId and :currentDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
	List<Prices> findByBrandProductAndTruncateDate(@Param("brandId") Long brandId,@Param("productId") Long productId, @Param("currentDate") Date currentDate);

}
