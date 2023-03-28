package com.inditex.zara.engine.data.mapper;

import com.inditex.zara.apimodel.model.BrandBean;
import com.inditex.zara.engine.data.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper
{
	BrandBean map(Brand bean);
	List<BrandBean> mapList(List<Brand> bean);
}
