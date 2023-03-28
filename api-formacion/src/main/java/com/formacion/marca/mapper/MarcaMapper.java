package com.formacion.marca.mapper;

import com.formacion.core.mapper.GenericMapper;
import com.formacion.marca.model.entity.Marca;
import com.formacion.marca.model.json.MarcaJson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MarcaMapper implements GenericMapper<Marca, MarcaJson> {
	public static final MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);
}
