package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalDto;

public interface Sucursalfacade extends BaseFacade<SucursalDto, Long> {
    SucursalDto createSucursal(SucursalDto dto);
    SucursalDto updateSucursal(Long id,SucursalDto dto);
}
