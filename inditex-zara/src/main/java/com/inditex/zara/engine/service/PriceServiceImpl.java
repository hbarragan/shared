package com.inditex.zara.engine.service;

import com.inditex.zara.apimodel.model.PriceBean;
import com.inditex.zara.apimodel.model.PriceFilter;
import com.inditex.zara.engine.data.mapper.PriceMapper;
import com.inditex.zara.engine.data.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PriceServiceImpl implements IPriceService
{
	@Autowired
	private PricesRepository repository;

	@Autowired
	private PriceMapper mapper;


	@Override
	public List<PriceBean> findAll() {
		return mapper.mapList (repository.findAll());

	}

	@Override
	public PriceBean findCurrentByFilter(PriceFilter filter){

		List<PriceBean> list = mapper.mapList(repository.findByBrandProductAndTruncateDate(filter.getBrandId(), filter.getProductId(), filter.getCurrentDate()));
	    return list!=null && list.size()>0 ? list.get(0): new PriceBean();
	}

}



