package com.inditex.zara.apimodel.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PriceFilter
{
	private Long brandId;
	private Long productId;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date currentDate;
}
