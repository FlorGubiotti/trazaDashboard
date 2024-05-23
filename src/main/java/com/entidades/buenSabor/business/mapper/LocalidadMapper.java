package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.localidad.LocalidadFullDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadFullDto> {
    @Mapping(target = "provincia", source = "idProvincia",qualifiedByName = "getById")
    Localidad toEntityCreate(LocalidadFullDto source);
    @Named("getAll")
    Localidad toEntity(LocalidadFullDto source);
}
