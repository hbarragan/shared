package com.inditex.zara.apirest.controller;

import com.inditex.zara.apimodel.model.PriceBean;
import com.inditex.zara.apimodel.model.PriceFilter;
import com.inditex.zara.apimodel.model.UrlConstants;
import com.inditex.zara.apimodel.response.JSONResult;
import com.inditex.zara.engine.service.IPriceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = UrlConstants.PRICES, produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController
{

	private IPriceService service;
	public PriceController(IPriceService service) {
		this.service = service;
	}


	@GetMapping
	public JSONResult<List<PriceBean>> findAll()
	{
		return new JSONResult<>(service.findAll());
	}

	@GetMapping(value = UrlConstants.CURRENT_PRICES)
	public JSONResult<PriceBean> findByFilter( PriceFilter filter)
	{
		return new JSONResult<>(service.findCurrentByFilter(filter));
	}

}
