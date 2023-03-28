package com.inditex.zara.engine.service;

import com.inditex.zara.apimodel.model.PriceBean;
import com.inditex.zara.apimodel.model.PriceFilter;

import java.util.List;

public interface IPriceService
{
	List<PriceBean> findAll();
	PriceBean findCurrentByFilter(PriceFilter filter);
}
