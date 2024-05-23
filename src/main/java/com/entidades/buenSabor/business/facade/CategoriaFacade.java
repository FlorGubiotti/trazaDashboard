package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaFullDto;

public interface CategoriaFacade extends BaseFacade<CategoriaFullDto, Long> {
    public CategoriaFullDto addInsumo(Long idCategoria, Long idInsumo);
    public CategoriaFullDto addManufacturado(Long idCategoria, Long idManufacturado);
    public CategoriaFullDto addSubCategoria(Long idCategoria, CategoriaFullDto subCategoria);
}
