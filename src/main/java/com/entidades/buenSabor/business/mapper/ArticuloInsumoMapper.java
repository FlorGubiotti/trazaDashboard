package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UnidadMedidaService.class, ImagenArticuloMapper.class})
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoFullDto> {
    @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById")
    @Mapping(target = "habilitado", constant = "true")
    ArticuloInsumo toEntityCreate(ArticuloInsumoFullDto source);
}
