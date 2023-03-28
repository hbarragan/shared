
package com.inditex.zara.apirest.controller;

import com.inditex.zara.apimodel.model.BrandBean;
import com.inditex.zara.apimodel.model.UrlConstants;
import com.inditex.zara.apimodel.response.JSONResult;
import com.inditex.zara.engine.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = UrlConstants.BRAND, produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController
{
	@Autowired
	private IBrandService service;

	@GetMapping
	public JSONResult<List<BrandBean>> findAll()
	{
		return new JSONResult<>(service.findAll());
	}

}
