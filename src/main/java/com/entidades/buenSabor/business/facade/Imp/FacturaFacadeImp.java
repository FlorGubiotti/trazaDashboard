package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.FacturaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.factura.FacturaFullDto;
import com.entidades.buenSabor.domain.entities.Factura;
import org.springframework.stereotype.Service;

@Service
public class FacturaFacadeImp extends BaseFacadeImp<Factura, FacturaFullDto, Long> implements FacturaFacade {

    public FacturaFacadeImp(BaseService<Factura, Long> baseService, BaseMapper<Factura, FacturaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
