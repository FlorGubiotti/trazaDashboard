package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.provincia.ProvinciaFullDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper extends BaseMapper<Provincia, ProvinciaFullDto>{
    @Mapping(target = "pais", source = "idPais",qualifiedByName = "getById")
    Provincia toEntityCreate(ProvinciaFullDto source);
}
