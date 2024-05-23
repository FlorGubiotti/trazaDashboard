package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.localidad.LocalidadFullDto;
import com.entidades.buenSabor.domain.dto.pais.PaisFullDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import com.entidades.buenSabor.domain.entities.Pais;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PaisMapper extends BaseMapper<Pais, PaisFullDto>{
    @Named("getAll")
    @Mapping(target = "nombre", source = "nombre")
    Pais toEntity(PaisFullDto source);

}
