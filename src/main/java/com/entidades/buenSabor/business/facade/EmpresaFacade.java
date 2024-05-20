package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;

import com.entidades.buenSabor.domain.dto.empresa.EmpresaDto;
import com.entidades.buenSabor.domain.dto.empresa.EmpresaLargeDto;


public interface EmpresaFacade extends BaseFacade<EmpresaDto, Long> {
    EmpresaLargeDto addSucursal(Long idEmpresa, Long idSucursal);
}
