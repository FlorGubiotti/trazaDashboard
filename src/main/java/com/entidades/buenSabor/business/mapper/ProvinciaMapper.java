package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.provincia.ProvinciaDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper extends BaseMapper<Provincia,ProvinciaDto>{

}
