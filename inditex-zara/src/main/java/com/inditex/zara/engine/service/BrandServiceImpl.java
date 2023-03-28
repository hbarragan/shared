package com.inditex.zara.engine.service;

import com.inditex.zara.apimodel.model.BrandBean;
import com.inditex.zara.engine.data.mapper.BrandMapper;
import com.inditex.zara.engine.data.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService
{
	@Autowired
	private BrandRepository repository;


	@Autowired
	private BrandMapper mapper;

	@Override
	public List<BrandBean> findAll() {
		return mapper.mapList(repository.findAll());

	}
}



