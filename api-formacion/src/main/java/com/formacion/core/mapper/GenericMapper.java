package com.formacion.core.mapper;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface GenericMapper<I, O> {
    I convertByJson(O var1);

    @InheritInverseConfiguration
    O convertByEntity(I var1);

    List<I> convertByJson(List<O> var1);

    @InheritInverseConfiguration
    List<O> convertByEntity(List<I> var1);
}
