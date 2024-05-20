package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel =  "spring", uses = LocalidadMapper.class)
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto> {

    @Mapping(source = "articuloInsumo.id", target="articuloInsumoId")
    ArticuloManufacturadoDetalleDto toDTO(ArticuloManufacturadoDetalle source);

    @InheritInverseConfiguration
    ArticuloManufacturadoDetalle toEntity(ArticuloManufacturadoDetalleDto source);

}
