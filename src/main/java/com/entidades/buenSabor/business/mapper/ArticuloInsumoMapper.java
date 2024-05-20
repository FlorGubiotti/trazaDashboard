package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring", uses = LocalidadMapper.class)

public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDto> {
}
