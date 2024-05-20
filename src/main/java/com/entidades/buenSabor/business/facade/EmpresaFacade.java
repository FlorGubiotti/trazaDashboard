package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;

import com.entidades.buenSabor.domain.dto.empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.empresa.EmpresaFullDto;


public interface EmpresaFacade extends BaseFacade<EmpresaCreateDto, Long> {
    EmpresaFullDto addSucursal(Long idEmpresa, Long idSucursal);
}
