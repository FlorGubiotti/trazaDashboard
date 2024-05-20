package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloManufacturadoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoFacadeImp extends BaseFacadeImp<ArticuloManufacturado, ArticuloManufacturadoFullDto,Long> implements ArticuloManufacturadoFacade {
    public ArticuloManufacturadoFacadeImp(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
