package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ArticuloInsumoService.class})
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto> {

    @Mapping(source = "articuloInsumo.id", target="articuloInsumo.id")
    ArticuloManufacturadoDetalleFullDto toDTO(ArticuloManufacturadoDetalle source);

    @InheritInverseConfiguration
    ArticuloManufacturadoDetalle toEntity(ArticuloManufacturadoDetalleFullDto source);
    @Mapping(target = "articuloInsumo", source = "idArticuloInsumo", qualifiedByName = "getById")
    ArticuloManufacturadoDetalle toEntityCreate(ArticuloManufacturadoDetalleFullDto source);

}
