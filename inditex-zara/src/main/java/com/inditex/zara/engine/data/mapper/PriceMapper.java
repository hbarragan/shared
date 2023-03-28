package com.inditex.zara.engine.data.mapper;

import com.inditex.zara.apimodel.model.PriceBean;
import com.inditex.zara.engine.data.model.Prices;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BrandMapper.class })
public interface PriceMapper
{
	PriceBean map(Prices bean);
	List<PriceBean> mapList(List<Prices> bean);
}
