package com.inditex.zara.apimodel.model;

import com.inditex.zara.engine.data.model.Brand;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PriceBean
{
	private static final long serialVersionUID = 6294472005527545105L;

	private Long id;
	private Brand brand;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date startDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date endDate;
	private Integer priceList;
	private Long productId;
	private Integer priority;
	private Double price;
	private String curr;
}
