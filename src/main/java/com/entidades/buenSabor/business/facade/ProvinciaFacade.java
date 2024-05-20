package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.provincia.ProvinciaDto;

import java.util.List;

public interface ProvinciaFacade extends BaseFacade<ProvinciaDto, Long> {
    List<ProvinciaDto> findByPaisId(Long id);
}
