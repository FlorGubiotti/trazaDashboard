package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ArticuloManufacturadoDetalleMapper.class, UnidadMedidaService.class, ImagenArticuloMapper.class})

public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDto> {

}
