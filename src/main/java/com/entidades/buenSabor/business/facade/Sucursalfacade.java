package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalFullDto;

public interface Sucursalfacade extends BaseFacade<SucursalFullDto, Long> {
    SucursalFullDto createSucursal(SucursalFullDto dto);
    SucursalFullDto updateSucursal(Long id, SucursalFullDto dto);
}
